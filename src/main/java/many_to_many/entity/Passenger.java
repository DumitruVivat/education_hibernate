package many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pass")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @ManyToMany(cascade = {CascadeType.DETACH,
                           CascadeType.MERGE,
                           CascadeType.PERSIST,
                           CascadeType.REFRESH})
    @JoinTable(name = "pass_taxi",
               joinColumns = @JoinColumn(name = "pass_id"),
               inverseJoinColumns = @JoinColumn(name = "taxi_id"))
    private List<Taxi> taxiList;

    public Passenger() {
    }

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Taxi> getTaxiList() {
        return taxiList;
    }

    public void setTaxiList(List<Taxi> taxiList) {
        this.taxiList = taxiList;
    }

    public void addTaxiToPassenger(Taxi taxi){
        if(taxiList == null){
            taxiList = new ArrayList<>();
        }
        taxiList.add(taxi);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
