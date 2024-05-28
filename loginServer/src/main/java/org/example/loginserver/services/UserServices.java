package org.example.loginserver.services;

import org.example.loginserver.domain.model.Coach;
import org.example.loginserver.domain.model.Coachee;
import org.example.loginserver.domain.model.Users;
import org.example.loginserver.common.Config;
import org.example.loginserver.common.Constantes;

import org.example.loginserver.dao.CoachDao;
import org.example.loginserver.dao.CoacheeDao;
import org.example.loginserver.dao.UserDao;
import org.example.loginserver.spring.auth.AuthenticationResponse;
import org.example.loginserver.spring.rest.errors.exceptions.CredentialInvalid;
import org.example.loginserver.spring.rest.errors.exceptions.UserExistException;
import org.example.loginserver.spring.rest.security.TokensGenerator;
import org.example.loginserver.spring.utils.Utils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserDao dao;
    private final CoachDao daoCoach;
    private final CoacheeDao daoCoachee;
    private final Config co;

    private final TokensGenerator tokensGenerator;
    private final AuthenticationManager authenticationManager;

    public UserServices(UserDao dao, CoachDao daoCoach, CoacheeDao daoCoachee, Config co, TokensGenerator tokensGenerator, AuthenticationManager authenticationManager) {
        this.dao = dao;
        this.daoCoach = daoCoach;
        this.daoCoachee = daoCoachee;
        this.co = co;
        this.tokensGenerator = tokensGenerator;
        this.authenticationManager = authenticationManager;
    }

    public boolean register(String email, String passw, String name, String lastname, String rol) {
        if (!dao.findByEmail(email).isPresent()) {
            String str = co.createPasswordEncoder().encode(passw);

            dao.save(new Users(email, str,  rol));
            Users us = dao.findByEmail(email).get();
            String code=Utils.randomBytes();
            daoCoach.save(new Coach(us.getId(),name,lastname,code ));


            //poner excepcion


            return true;
        } else {
            throw new UserExistException();
        }
    }

    public Users getUserByEmail(String email){
        return dao.findByEmail(email).orElseThrow(UserExistException::new);
    }
    public boolean registerCoachee(String email, String passw, String username, String rol,String code ) {
        if (!dao.findByEmail(email).isPresent()) {
            String str = co.createPasswordEncoder().encode(passw);

            dao.save(new Users(email, str,  rol));
            Users us = dao.findByEmail(email).get();
            Coach c=daoCoach.findByCoachCode(code).get();
            if(c!=null) daoCoachee.save(new Coachee(us.getId(),username,c.getId()));



            //poner excepcion


            return true;
        } else {
            throw new UserExistException();
        }
    }

    public AuthenticationResponse login(String email, String passw) {
        try {
            Authentication auth =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(email, passw));
            List<String> tokens = new ArrayList<>();
            if (auth.isAuthenticated()) {
                Users credentials = dao.findByEmail(email).orElseThrow(() -> new CredentialInvalid(Constantes.CREDENTIAL_INVALIDA));
                tokens.add(tokensGenerator.generateAccessToken(credentials));
                tokens.add(tokensGenerator.generateRefreshToken(credentials));
                return AuthenticationResponse.builder()
                        .accessToken(tokens.get(0))
                        .refreshToken(tokens.get(1))
                        .build();

            } else {
                throw new CredentialInvalid(Constantes.CREDENTIAL_INVALIDA);
            }
        } catch (BadCredentialsException e) {
            throw new CredentialInvalid(Constantes.USUARIO_NO_ENCONTRADO);
        }

    }

    public String getAccessToken(String header) {
        return tokensGenerator.getNewAccesTokenFromRefreshToken(header);

    }
}
