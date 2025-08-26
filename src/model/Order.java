package model;

import model.Customer;

import java.util.ArrayList;

public class Order {

    private static int contador = 1;
    private int id;
    private ArrayList<OrderItem> items;
    private Customer customer;

    public Order(Customer customer) {
        this.id = contador;
        contador++;
        this.items = new ArrayList<>();
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }
}
