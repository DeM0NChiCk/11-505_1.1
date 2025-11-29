import model.Client;
import model.Product;
import model.User;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("pr1", 1, 20, 20.0);
        System.out.println(Product.countAll);
        Product.setCountAll(product1);
        System.out.println(Product.countAll);
        Product product2 = new Product("pr2", 2, 40, 30.0);
        System.out.println(Product.countAll);
        Product.setCountAll(product2);
        System.out.println(Product.countAll);


        User user1 = new User(
                1,
                "R",
                22,
                " ",
                "DE",
                "12345"
        );
        user1.print();

        Client client1 = new Client(
                1,
                "R",
                22,
                " ",
                "12345",
                "Kazan"
        );
        client1.print();;


    }
}