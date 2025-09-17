package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService1 = (PersonService) context.getBean("person");
        PersonService personService2 = (PersonService) context.getBean("person");
        PersonService personService3 = (PersonService) context.getBean("person");
        context.close();
    }
}