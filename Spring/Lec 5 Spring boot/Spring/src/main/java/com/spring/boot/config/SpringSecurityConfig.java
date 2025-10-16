package com.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(HttpMethod.GET,"/teachers").hasAnyRole("ADMIN","USER")
                .requestMatchers(HttpMethod.GET,"/teacher/username/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }



    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails1 =
                User.withUsername("ahmed")
                        .password("{bcrypt}$2a$12$VEQa0FbACviCz31jFgEsnuBEuLmIogwJKUnoDAQWtdk2PgwAVDpDa").roles("USER").build();

        UserDetails userDetails2 =
                User.withUsername("john")
                        .password("{bcrypt}$2a$12$VEQa0FbACviCz31jFgEsnuBEuLmIogwJKUnoDAQWtdk2PgwAVDpDa").roles("ADMIN").build();

        UserDetails userDetails3 =
                User.withUsername("omar")
                        .password("{bcrypt}$2a$12$VEQa0FbACviCz31jFgEsnuBEuLmIogwJKUnoDAQWtdk2PgwAVDpDa").build();

        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
    }
}
