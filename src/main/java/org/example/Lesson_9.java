package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson_9 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure().buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            var car = session.get(Car.class, 6);
//            car.setName("Honda");

//            session.createQuery("update Car set price=55000 where year=2023").executeUpdate();
            session.createQuery("update Car set price=88000 where color='black'").executeUpdate();


            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
