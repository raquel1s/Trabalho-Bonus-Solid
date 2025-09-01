package repository;

import model.Order;
import repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class Database implements OrderRepository {

    List<Order> orders = new ArrayList<>();
    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Pedido salvo com sucesso!");
    }
}
