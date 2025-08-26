package model;

public class OrderItem {

    private String name;
    private double price;
    private int quantity;

    public OrderItem(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  "\nNome: " + name +
                "\nPreço: " + price +
                '\n';
    }
}
