package many_to_many;

import many_to_many.entity.Passenger;
import many_to_many.entity.Taxi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
                .addAnnotatedClass(Taxi.class)
                .buildSessionFactory();

        Session session = null;
        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

//            Taxi taxi1 = new Taxi("MAZDA");
//            Taxi taxi2 = new Taxi("SKODA");
//            Passenger passenger1 = new Passenger("Andrei", 26);
//            Passenger passenger2 = new Passenger("Alina", 25);
//            Passenger passenger3 = new Passenger("Dumitru", 29);
//            taxi1.addPassengersToTaxi(passenger1);
//            taxi2.addPassengersToTaxi(passenger2);
//            taxi2.addPassengersToTaxi(passenger3);
//            session.save(taxi2);

//            LESSON 32 ******************************************

//            Taxi taxi1 = session.get(Taxi.class, 1);
//            System.out.println(taxi1);
//            System.out.println(taxi1.getPassengerList());

//            Passenger passenger1 = session.get(Passenger.class, 4);
//            System.out.println(passenger1);
//            System.out.println(passenger1.getTaxiList());

//            LESSON 33 **********************************************

//            Taxi taxi3 = new Taxi("AUDI");
//            Passenger passenger3 = session.get(Passenger.class, 3);
//            Passenger passenger4 = session.get(Passenger.class, 4);
//            taxi3.addPassengersToTaxi(passenger3);
//            taxi3.addPassengersToTaxi(passenger4);
//            session.save(taxi3);

//            Passenger passenger3 = session.get(Passenger.class, 3);
//            session.delete(passenger3);

//            LESSON 34 **********************************************

            Taxi taxi1 = new Taxi("MAZDA");
            Taxi taxi2 = new Taxi("SKODA");
            Taxi taxi3 = new Taxi("FORD");

            session.save(taxi1);
            session.save(taxi2);
            session.save(taxi3);


            Passenger passenger1 = new Passenger("Andrei", 26);
            Passenger passenger2 = new Passenger("Alina", 25);
            Passenger passenger3 = new Passenger("Dumitru", 29);
            Passenger passenger4 = new Passenger("Serj", 27);
            Passenger passenger5 = new Passenger("Tatiana", 31);
            Passenger passenger6 = new Passenger("Anton", 32);

            session.save(passenger1);
            session.save(passenger2);
            session.save(passenger3);
            session.save(passenger4);
            session.save(passenger5);
            session.save(passenger6);

            taxi1.addPassengersToTaxi(passenger1);
            taxi1.addPassengersToTaxi(passenger2);
            taxi1.addPassengersToTaxi(passenger3);

            taxi2.addPassengersToTaxi(passenger2);
            taxi2.addPassengersToTaxi(passenger3);
            taxi2.addPassengersToTaxi(passenger4);

            taxi3.addPassengersToTaxi(passenger4);
            taxi3.addPassengersToTaxi(passenger5);
            taxi3.addPassengersToTaxi(passenger6);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
