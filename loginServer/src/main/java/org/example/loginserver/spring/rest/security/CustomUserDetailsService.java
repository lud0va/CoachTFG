package org.example.loginserver.spring.rest.security;


import org.example.loginserver.domain.model.Users;
import org.springframework.security.core.userdetails.User;
import org.example.loginserver.common.Constantes;
import org.example.loginserver.dao.UserDao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UserDao userRepository;

    public CustomUserDetailsService(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    Users user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(Constantes.USER_NOT_FOUND));


        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(
                        user.getRol())
                .build();

    }
}
