package Backpack;

public class Subject {
    private String name;
    private double weigth;
    private double price;

    public Subject(String name, double weigth, double price)
    {
        this.name = name;
        this.weigth = weigth;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeigth() {
        return weigth;
    }
}
