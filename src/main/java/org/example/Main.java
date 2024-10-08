package org.example;

import org.example.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Car car4 = new Car("Mazda", 2024, "Green", 85_000, 195.0);
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(car4);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
     }
}