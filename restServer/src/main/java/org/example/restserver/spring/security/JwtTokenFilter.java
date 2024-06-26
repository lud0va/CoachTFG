package org.example.restserver.spring.security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.restserver.common.Constantes;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final CustomUserDetailService userRepo;

    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil, CustomUserDetailService userRepo) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepo = userRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        try {
            final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (isEmpty(header) || !header.startsWith(Constantes.BEARER)) {
                chain.doFilter(request, response);
                return;
            }

            final String token = header.split(Constantes.SPACE)[1].trim();

            if (!jwtTokenUtil.validate(token)) {
                chain.doFilter(request, response);
                return;
            }

            UserDetails userDetails =
                    userRepo.createUser(jwtTokenUtil.getUsername(token), Constantes.EMPTY, jwtTokenUtil.getRole(token));


            UsernamePasswordAuthenticationToken
                    authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null,
                    userDetails == null ?
                            List.of() : userDetails.getAuthorities()
            );

            authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            Logger.getLogger(JwtTokenFilter.class.getName()).log(Level.SEVERE, e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(Constantes.EL_TOKEN_HA_CADUCADO);


        }


    }


}
