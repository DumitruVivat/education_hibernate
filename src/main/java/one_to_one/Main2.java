package one_to_one;

import one_to_one.entity.Car;
import one_to_one.entity.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Engine.class)
                .buildSessionFactory();

        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Car car1 = new Car("AUDI",1995,"Blue",600,200.0);
//            Engine engine1 = new Engine(333,3333);
//
//            car1.setCarEngine(engine1);
//            engine1.setCar(car1);
//            session.save(engine1);
//            Lesson 17 **************************************************
//
//            Engine engine = session.get(Engine.class, 3);
//            engine.getCar().setCarEngine(null);
////            System.out.println(engine.getCar());
//            session.delete(engine);

            session.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
    }
}
