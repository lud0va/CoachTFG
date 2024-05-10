package org.example.loginserver.spring;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;
import org.example.loginserver.common.Constantes;
import org.springframework.beans.factory.annotation.Value;

import javax.security.auth.x500.X500Principal;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CrearKeystore {
    @Value(Constantes.SECURITY_JWT_KEYSTORE_NAME)
    private String keystorename;
    @Value(Constantes.APPLICATION_SECURITY_JWT_CLAVE)
    private String claveKeystore;
    @Value(Constantes.SECURITY_JWT_SERVER_NAME)
    private String serverName;

    public static void main(String[] args) {

        try {
            //dejo el crear zkeystore por si necesitas crear la keystore otra vez para ver si lo hago bien o alguna cosa así
            Security.addProvider(new BouncyCastleProvider());

            String s ="Coachs001";
            //crear claves privadas
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            KeyPair claveBase64 = gen.generateKeyPair();
            PrivateKey clavePriv = claveBase64.getPrivate();
            PublicKey clavePub = claveBase64.getPublic();
            //iniciar keystore
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(null, null);
            char[] keystorePassword = "Coachs001".toCharArray();


            //certificar clave publica
            X509V3CertificateGenerator cert1 = new X509V3CertificateGenerator();
            cert1.setSerialNumber(BigInteger.valueOf(1));
            cert1.setIssuerDN(new X500Principal("CN="+"server"));
            cert1.setSubjectDN(new X500Principal("CN="+"server"));
            cert1.setPublicKey(clavePub);
            cert1.setNotBefore(
                    Date.from(LocalDate.now().plus(365, ChronoUnit.DAYS).atStartOfDay().toInstant(ZoneOffset.UTC)));
            cert1.setNotAfter(new Date());
            cert1.setSignatureAlgorithm("SHA256WithRSAEncryption");
            X509Certificate cert =cert1.generateX509Certificate(clavePriv);


            // meter la claves del servidor
            keyStore.load(null, null);
            keyStore.setCertificateEntry("server", cert);
            keyStore.setKeyEntry("server", clavePriv, "Coachs001".toCharArray(), new java.security.cert.Certificate[]{cert});

            keyStore.store(new FileOutputStream("keystoreCoach.pfx"), s.toCharArray());

            // meter la claves del servidor
        } catch (KeyStoreException | CertificateException | IOException | NoSuchAlgorithmException |
                 InvalidKeyException | SignatureException e) {
            throw new IllegalStateException(e);
        }
    }
}
