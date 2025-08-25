public class Database {

    private OrderRepository repository;

    public Database(OrderRepository repository) {
        this.repository = repository;
    }

    public void processOrder(Order order){
        repository.save(order);
    }
}
