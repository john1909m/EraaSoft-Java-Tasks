package com.java.hibernate;

import com.java.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Player.class)
                .configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Player player1=new Player(1, "Player 1", 20, true);
        Player player2=new Player(2, "Player 2", 25, true);
        Player player3=new Player(3, "Player 3", 29, false);
        session.save(player1);
        session.save(player2);
        session.save(player3);
        player2.setName("john");
        session.update(player2);
        session.delete(player3);

        Player player4=session.get(Player.class, 1);
        System.out.println(player4);
        transaction.commit();
        System.out.println(session);
        session.close();

    }
}