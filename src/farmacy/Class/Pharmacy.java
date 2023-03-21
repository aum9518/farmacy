package farmacy.Class;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Pharmacy {
    private int id;
    private String name;
    private String address;
    private List<Person>people;
    private List<Madicine>madicines;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Pharmacy(int id, String name, String address, List<Person> people, List<Madicine> madicines) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.people = people;
        this.madicines = madicines;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Madicine> getMadicines() {
        return madicines;
    }

    public void setMadicines(List<Madicine> madicines) {
        this.madicines = madicines;
    }

    public Pharmacy(String name, String address, List<Person> people, List<Madicine> madicines) {
        this.name = name;
        this.address = address;
        this.people = people;
        this.madicines = madicines;
    }

    public Pharmacy() {
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", people=" + people +
                ", madicines=" + madicines +
                '}';
    }
}
