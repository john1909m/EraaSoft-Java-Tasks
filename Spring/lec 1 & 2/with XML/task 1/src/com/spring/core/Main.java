package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonService) context.getBean("person");
        MangerService mangerService = (MangerService) context.getBean("manger");
        personService.save("john");
        mangerService.save("andrew");
        personService.update("john 2");
        mangerService.update("andrew 2");


    }
}