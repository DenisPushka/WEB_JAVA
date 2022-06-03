package models;

public class Auto {
    private int id;
    private String model;
    private String color;
    private User user;

    public Auto(){}

    public Auto(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Auto(String model, String color, User user) {
        this.model = model;
        this.color = color;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", user=" + user +
                '}';
    }
}
