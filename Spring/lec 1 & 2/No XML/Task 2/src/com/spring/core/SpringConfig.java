package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public UserService personService() {
        return new PersonService();
    }

    @Bean
    public AccountServiceImpl accountService() {
        return new AccountServiceImpl(personService());
    }
}
