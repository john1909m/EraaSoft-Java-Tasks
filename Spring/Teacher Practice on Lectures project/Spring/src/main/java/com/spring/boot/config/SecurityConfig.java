package com.spring.boot.config;

import com.spring.boot.service.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import javax.swing.*;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    public UserDetailsService jdbc(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        return jdbcUserDetailsManager;
//    };
    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated()).userDetailsService(customUserDetailsService);

//        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails1 =
//                User.withUsername("ahmed")
//                        .password("{bcrypt}$2a$12$VEQa0FbACviCz31jFgEsnuBEuLmIogwJKUnoDAQWtdk2PgwAVDpDa").roles("USER").build();
//
//        UserDetails userDetails2 =
//                User.withUsername("john")
//                        .password("{bcrypt}$2a$12$VEQa0FbACviCz31jFgEsnuBEuLmIogwJKUnoDAQWtdk2PgwAVDpDa").roles("ADMIN").build();
//
//        UserDetails userDetails3 =
//                User.withUsername("omar")
//                        .password("{bcrypt}$2a$12$VEQa0FbACviCz31jFgEsnuBEuLmIogwJKUnoDAQWtdk2PgwAVDpDa").build();
//
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
//    }
}
