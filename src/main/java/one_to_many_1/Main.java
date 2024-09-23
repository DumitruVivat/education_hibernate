package one_to_many_1;

import one_to_many_1.entity.Car;
import one_to_many_1.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();

        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();


//            Owner owner = new Owner("Ecaterina", 23);
//            Car car1 = new Car("FIAT", 160.0);
//            Car car2 = new Car("FERRARI", 270.0);
//            owner.addCarToOwner(car1);
//            owner.addCarToOwner(car2);
//            session.save(owner);

//            var car = session.get(Car.class, 14);
//            session.delete(car);

            var owner = session.get(Owner.class, 6);
            session.delete(owner);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
