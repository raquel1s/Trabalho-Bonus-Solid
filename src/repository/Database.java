package repository;

import model.Order;
import repository.OrderRepository;

public class Database implements OrderRepository {

    @Override
    public void save(Order order) {
        System.out.println("Pedido salvo com sucesso!");
    }
}
