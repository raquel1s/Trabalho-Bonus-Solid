import model.Customer;
import model.Order;
import model.OrderItem;
import notification.EmailSender;
import notification.Notifier;
import repository.Database;
import repository.OrderRepository;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static OrderRepository repository = new Database();
    private static Notifier notifier = new EmailSender();
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
        System.out.println("-- Criar Pedido --");


    }

    private static void criarCliente() {
        System.out.println("-- Adicionar Cliente --");
        System.out.println("Digite seu email: ");
        String email = sc.nextLine();

        Customer customer = new Customer(email);
        customers.add(customer);
    }
}