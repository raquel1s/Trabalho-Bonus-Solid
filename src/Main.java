import model.Customer;
import model.Order;
import model.OrderItem;
import notification.EmailSender;
import notification.Notifier;
import payment.CreditCardPayment;
import payment.PaymentMethod;
import payment.PaymentMethodStrategy;
import payment.PixPayment;
import repository.Database;
import repository.OrderRepository;
import service.CheckoutService;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static OrderRepository repository = new Database();
    private static Notifier notifier = new EmailSender();
    private static CheckoutService checkoutService = new CheckoutService(repository, notifier);
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<OrderItem> items = new ArrayList<>();

    public static void main(String[] args) {
        inicio();
    }

    private static void inicio() {
        int opcao = 0;

        do{
            Menu.exibir();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1 -> criarCliente();
                case 2 -> criarPedido();
                case 3 -> criarItem();
                default -> System.out.println("Opção Inválida!");
            }

        }while (opcao != 0);
    }

    private static void criarItem() {
        System.out.println("-- Adicionar item --");
        System.out.println("Digite o nome do Item: ");
        String nome = sc.nextLine();

        System.out.println("Digite o preço do Item: ");
        double preco = sc.nextDouble();

        OrderItem item = new OrderItem(preco, nome);
        items.add(item);
    }

    private static void criarPedido() {
        int opcao = 0;
        ArrayList<OrderItem> itensPedido = new ArrayList<>();
        Customer customer = null;
        PaymentMethodStrategy paymentMethod = null;

        System.out.println("-- Criar Pedido --");

        do{
            for (OrderItem it : items) {
                System.out.println(it);
            }

            System.out.println("Digite o nome do item: ");
            String nome = sc.nextLine();

            for(OrderItem it : items){
                if(nome.equals(it.getName())){
                    itensPedido.add(it);
                }
            }

            System.out.println("Deseja adicionar mais um item?");
            System.out.println("1- SIM");
            System.out.println("0- NÃO");
            opcao = sc.nextInt();
            sc.nextLine();

        }while(opcao != 0);

        for(Customer c : customers){
            System.out.println(c);
        }

        System.out.println("Digite o email do cliente: ");
        String email = sc.nextLine();

        for(Customer c : customers){
            if(email.equals(c.getEmail())){
                customer = c;
            }
        }

        Order order = new Order(customer, itensPedido);

        System.out.println("Digite a forma de pagamento: ");
        System.out.println("1 - PIX");
        System.out.println("2 - Cartão de crédito");
        int pagameto = sc.nextInt();

        switch (pagameto){
            case 1 -> paymentMethod = new PixPayment();
            case 2 -> paymentMethod = new CreditCardPayment();
        }

        checkoutService.checkout(order, paymentMethod);
    }

    private static void criarCliente() {
        boolean isEstudante = true;
        System.out.println("-- Adicionar Cliente --");
        System.out.println("Digite seu email: ");
        String email = sc.nextLine();

        System.out.println("O cliente é estudante?");
        System.out.println("1- SIM");
        System.out.println("0- NÃO");
        int estudante = sc.nextInt();

        if(estudante == 0){
            isEstudante = false;
        }

        Customer customer = new Customer(email, isEstudante);
        customers.add(customer);
    }
}