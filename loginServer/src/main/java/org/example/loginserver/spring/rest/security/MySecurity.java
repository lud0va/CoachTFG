package org.example.loginserver.spring.rest.security;


import lombok.RequiredArgsConstructor;
import org.example.loginserver.common.Constantes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = false, jsr250Enabled = true)
public class MySecurity {




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http


                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(Constantes.LOGIN).permitAll()
                                .requestMatchers(Constantes.REGISTER).permitAll()
                                .requestMatchers(Constantes.GET_USER_BY_EMAIL).permitAll()
                                .requestMatchers(Constantes.GETACCESSTOKEN).permitAll()
                                .requestMatchers(Constantes.REGISTERCOACHEE).permitAll()
                                .anyRequest().authenticated()


                ).build();
    }


}
