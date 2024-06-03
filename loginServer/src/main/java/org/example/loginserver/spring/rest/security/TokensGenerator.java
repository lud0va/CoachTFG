package org.example.loginserver.spring.rest.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.example.loginserver.domain.model.Users;
import org.example.loginserver.common.Constantes;

import org.example.loginserver.dao.UserDao;
import org.example.loginserver.spring.rest.errors.exceptions.TokenInvalidoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TokensGenerator {
    @Value(Constantes.SECURITY_JWT_KEYSTORE_NAME)
    private String keystorename;
    @Value(Constantes.APPLICATION_SECURITY_JWT_CLAVE)
    private String claveKeystore;
    @Value(Constantes.SECURITY_JWT_SERVER_NAME)
    private String serverName;
    @Value(Constantes.APPLICATION_SECURITY_JWT_ACCESS_EXPIRATION)
    private long refreshExpiration;
    @Value(Constantes.APPLICATION_SECURITY_JWT_REFRESH_TOKEN_EXPIRATION)
    private  long access;


    private final UserDao dao;

    public TokensGenerator( UserDao dao) {

        this.dao = dao;
    }


    public String generateAccessToken(Users users) {
        try {
            // Cargar el keystore
            KeyStore keyStore = KeyStore.getInstance(Constantes.PKCS_12);
            //cargar el keystore con la clave del servidore
            keyStore.load(new FileInputStream(keystorename), claveKeystore.toCharArray());

            // Obtener la clave privada del servidor con la clave
            KeyStore.PasswordProtection keyPassword = new KeyStore.PasswordProtection(claveKeystore.toCharArray());
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(serverName, keyPassword);
            PrivateKey privateKey = privateKeyEntry.getPrivateKey();


            // Construir el token JWT
            //firmar el token con la clave
            return  Jwts.builder()
                    .setSubject(users.getEmail())
                    .claim(Constantes.ROLE, users.getRol())
                    .setExpiration(Date
                            .from(LocalDateTime.now().plusSeconds(access)
                                    .atZone(ZoneId.systemDefault()).toInstant()))
                    .signWith(privateKey)
                    .compact();
        } catch (CertificateException | KeyStoreException | IOException | NoSuchAlgorithmException |
                 UnrecoverableEntryException e) {
            Logger.getLogger(TokensGenerator.class.getName()).log(Level.SEVERE, null, e);
            throw new TokenInvalidoException(e.getMessage());

        }
    }

    public String getNewAccesTokenFromRefreshToken(String header) {
        try {
            // Cargar el keystore
            KeyStore keyStore = KeyStore.getInstance(Constantes.PKCS_12);
            keyStore.load(new FileInputStream(keystorename), claveKeystore.toCharArray());

            // Obtener la clave privada del servidor
            KeyStore.PasswordProtection keyPassword = new KeyStore.PasswordProtection(claveKeystore.toCharArray());
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(serverName, keyPassword);
            PrivateKey privateKey = privateKeyEntry.getPrivateKey();

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(privateKey)
                    .build()
                    .parseClaimsJws(header)
                    .getBody();
            String role = dao.findByEmail(claims.get(Constantes.EMAIL).toString()).orElseThrow().getRol();

            return  Jwts.builder()
                    .setSubject(claims.get(Constantes.EMAIL).toString())
                    .claim(Constantes.ROLE, role)
                    .setExpiration(Date
                            .from(LocalDateTime.now().plusSeconds(access)
                                    .atZone(ZoneId.systemDefault()).toInstant()))
                    .signWith(privateKey)

                    .compact();
        } catch (CertificateException | KeyStoreException | IOException | NoSuchAlgorithmException |
                 UnrecoverableEntryException e) {
            throw new TokenInvalidoException(e.getMessage());

        }
    }


    public String generateRefreshToken(Users credentials) {
        try {
            // Cargar el keystore
            KeyStore keyStore = KeyStore.getInstance(Constantes.PKCS_12);
            keyStore.load(new FileInputStream(keystorename), claveKeystore.toCharArray());

            // Obtener la clave privada del servidor
            KeyStore.PasswordProtection keyPassword = new KeyStore.PasswordProtection(claveKeystore.toCharArray());
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(serverName, keyPassword);
            PrivateKey privateKey = privateKeyEntry.getPrivateKey();


            // Construir el token JWT

            return Jwts.builder()
                    .setSubject(credentials.getEmail())
                    .claim(Constantes.EMAIL, credentials.getEmail())
                    .setExpiration(Date.from(LocalDateTime.now().plusMinutes(refreshExpiration)
                            .atZone(ZoneId.systemDefault()).toInstant()))
                    .claim(Constantes.ROLE, credentials.getRol())
                    .signWith(privateKey)

                    .compact();
        } catch (CertificateException | KeyStoreException | IOException | NoSuchAlgorithmException |
                 UnrecoverableEntryException e) {
            Logger.getLogger(TokensGenerator.class.getName()).log(Level.SEVERE, Constantes.ERROR_WHILE_PROCESSING_TOKENS, e);
            throw new TokenInvalidoException(Constantes.ERROR_WHILE_PROCESSING_TOKENS +e.getMessage());
        }
    }
}
