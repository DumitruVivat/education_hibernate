package one_to_one;

import one_to_one.entity.Car;
import one_to_one.entity.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
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

            //Lesson 13 *******************************************
//            Car car1 = new Car("BMW",2022,"White",3000,248.0);
//            Engine engine1 = new Engine(450,1750);
//            car1.setCarEngine(engine1);
//            session.save(car1);

            //Lesson 14 ******************************************

//            Car car1 = session.get(Car.class, 3);
//            Engine engine = session.get(Engine.class, 1);
//            System.out.println(engine);
//            List<Car> cars = session.createQuery("from Car where name='Volva' ").getResultList();
//            System.out.println(cars);

//            Car ca3 = session.get(Car.class, 3);
//            session.delete(ca3);

//            Engine engine3 = session.get(Engine.class, 1);
//            session.delete(engine3);

            Car ca4 = session.get(Car.class, 5);
            session.delete(ca4);
            System.out.println(ca4);

            session.getTransaction().commit();
        } catch (IllegalArgumentException e){
            System.out.println(e);
        } finally {
            session.close();
            factory.close();
        }
    }
}
