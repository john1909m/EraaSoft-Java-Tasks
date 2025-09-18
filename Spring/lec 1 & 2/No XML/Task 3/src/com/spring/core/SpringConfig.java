package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class SpringConfig {

    @Bean(initMethod = "openConnection",destroyMethod = "closeConnection")
    @Scope("prototype")
    public UserService personService() {
        return new PersonService();
    }

}
