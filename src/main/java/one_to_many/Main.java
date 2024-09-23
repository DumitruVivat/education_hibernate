package one_to_many;

import one_to_many.entity.Car;
import one_to_many.entity.Owner;
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

//        Owner owner1 = new Owner("Bogdan", 26);
//        Car car1 = new Car("MAZDA", 200.0);
//        Car car2 = new Car("RENO", 160.0);
//
//        owner1.addCarToOwner(car1);
//        owner1.addCarToOwner(car2);
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();


//            Owner owner4 = new Owner("owner_4", 25);
//            Car car1 = new Car("owner_4_car1", 200.0);
//            Car car2 = new Car("owner_4_car2", 300.0);
//            Car car3 = new Car("owner_4_car3", 400.0);
//            Car car4 = new Car("owner_4_car4", 500.0);
//            owner4.addCarToOwner(car1);
//            owner4.addCarToOwner(car2);
//            owner4.addCarToOwner(car3);
//            owner4.addCarToOwner(car4);
//            session.save(owner4);

            Owner owner = session.get(Owner.class, 8);
            System.out.println(owner);
            System.out.println("-----------------------------------");
            System.out.println("Cars");
            System.out.println(owner.getCars());

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
