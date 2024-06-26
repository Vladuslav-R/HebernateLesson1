package org.example;


import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = session.get(Person.class, 3);
            System.out.println("Получили человека");
            System.out.println(person.getItems());


            session.getTransaction().commit();
        }
    }
}