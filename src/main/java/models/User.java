package models;
import java.util.List;

public class User {
    private int id;

    private String name;

    private int age;

    private List<Auto> autos;

    public User(){}

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addAuto(Auto auto){
        auto.setUser(this);
        autos.add(auto);
    }

    public void RemoveAuto(Auto auto){
        autos.remove(auto);
    }

    public int getId() {
        return id;
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

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
