package org.example.loginserver.spring.rest;

import org.example.loginserver.common.Constantes;
import org.example.loginserver.domain.model.Users;
import org.example.loginserver.services.UserServices;
import org.example.loginserver.spring.auth.AuthenticationResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
public class RestUser {
    private final UserServices serv;

    public RestUser(UserServices serv) {
        this.serv = serv;
    }
    @GetMapping(Constantes.LOGIN)
    public AuthenticationResponse login(@RequestParam(name = Constantes.EMAIL, required = true) String email, @RequestParam(name = Constantes.PASSWORD, required = false) String password) {


        return serv.login(email, password);

    }
    @GetMapping(Constantes.GET_USER_BY_EMAIL)
    public Users getUserByEmail(@RequestParam(name = Constantes.EMAIL, required = true) String email) {


        return serv.getUserByEmail(email);

    }

    @GetMapping(Constantes.REGISTER)
    public Boolean registerCoach(@RequestParam(name = Constantes.EMAIL) String email, @RequestParam(name = Constantes.PASSWORD) String password, @RequestParam(name = Constantes.NAME) String name, @RequestParam(name =Constantes.LASTNAME) String lastname) {
        return serv.register(email, password,name,lastname,"coach");
    }
    @GetMapping(Constantes.REGISTERCOACHEE)
    public Boolean registerCoachee(@RequestParam(name = Constantes.EMAIL) String email, @RequestParam(name = Constantes.PASSWORD) String password, @RequestParam(name="username")String userename,@RequestParam(name = "coachCode")String coachCode,@RequestParam(name = "sex") String  sex,@RequestParam(name = "age")int age,@RequestParam("weight") int weight) {
        return serv.registerCoachee(email, password,userename,"coachee",coachCode,sex,age,weight);
    }

    @GetMapping(Constantes.GETACCESSTOKEN)
    public String getAccessToken(@RequestParam(name = Constantes.REFRESHTOKEN) String refresh) {
        return serv.getAccessToken(refresh);


    }



}
