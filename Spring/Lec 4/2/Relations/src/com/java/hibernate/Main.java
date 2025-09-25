package com.java.hibernate;

import com.java.model.Doctor;
import com.java.model.DoctorDetails;
import com.java.model.Hospital;
import com.java.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Hospital.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(DoctorDetails.class)
                .configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session);
        session.close();
    }
}