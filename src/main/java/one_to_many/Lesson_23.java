package one_to_many;

import one_to_many.entity.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson_23 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Owner owner = session.get(Owner.class, 2);
//            System.out.println(owner);
//            System.out.println(owner.getCars());

//            Car car = session.get(Car.class, 3);
//            System.out.println(car);
//            System.out.println(car.getOwner());

//            List<Car> cars = session.createQuery("from Car where speed > 122 and id = 4").getResultList();
//            for (Car car : cars) {
//                System.out.println(car);
//            }
//            System.out.println(cars);

//            Lesson 24 *******************************************************

//            var car1 = session.get(Car.class, 5);
//            session.delete(car1);
            var owner = session.get(Owner.class, 3);
            session.delete(owner);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
