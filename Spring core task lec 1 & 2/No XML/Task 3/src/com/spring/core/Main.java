package com.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        PersonService personService1 = (PersonService) context.getBean("personService");
        PersonService personService2 = (PersonService) context.getBean("personService");
        PersonService personService3 = (PersonService) context.getBean("personService");
        context.close();
    }
}