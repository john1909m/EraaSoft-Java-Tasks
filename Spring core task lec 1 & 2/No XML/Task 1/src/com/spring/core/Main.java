package com.spring.core;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService personService = (UserService) context.getBean("personService");
            personService.save("john");
            personService.update("john 2");

        UserService managerService = (UserService) context.getBean("mangerService");
            managerService.save("omar");
            managerService.update("omar 2");
    }
}