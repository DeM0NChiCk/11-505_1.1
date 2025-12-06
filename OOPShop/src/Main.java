
import model.*;
import service.LoadService;

public class Main {
    public static void main(String[] args) {

//        User user1 = new User(
//                1,
//                "R",
//                22,
//                " ",
//                "DE",
//                "12345"
//        );
//        user1.print();

        System.out.println("--------------");

        Client client1 = new Client(
                1,
                "R",
                22,
                " ",
                "12345",
                "Kazan"
        );
        client1.print();

        System.out.println("--------------");

        Employee employee = new Employee(
                "R",
                30,
                "Emp1",
                "Emp1@itis.ru",
                "qewrqewr",
                111111,
                "IT Java prog",
                "IT"
        );
        System.out.println("--------------");
        employee.print();
        System.out.println(employee.getId());

        System.out.println("--------------");

        User[] users = {
                client1,
                employee,
                new VIP(1, "R", 30, "VIP", "121234", "Kazan")
        };

        for (User us: users) {
            us.print();
        }

        System.out.println("--------------");

        Employee userEmp = (Employee) users[1];
        System.out.println(userEmp.getDepartment());
        userEmp.print();

        System.out.println("-------------- EMP");

//        Client userClient = (Client) users[2];
//        System.out.println(userClient.getUsername());
//        userEmp.print();

        System.out.println("-------------- VIP");

        VIP userVip = (VIP) users[2];
        System.out.println(userVip.getUsername());
        userVip.print();

        System.out.println("--------------VIP");

        Client userVip2 = (VIP) (users[2]);
        System.out.println(userVip2.getUsername());
        userVip2.print();

        System.out.println("--------------");
        for (User user: users) {
            user.print();
            System.out.println("--------------");
        }

        Shop shop = new Shop("qewfeqw", "wewef", "wefwef", new Product[2]);
        Storage storage = new Storage("wefwef", "wewwefewef", "wefwergvertef", 4, 10);
        LoadService loadService = storage;
        LoadService[] loadServices = {shop, storage};

        loadService.load(new Product[5]);
        loadService.load(new Product[5]);
        loadService.load(new Product[5]);
        loadService.load(new Product[5]);
        loadService.load(new Product[5]);

        loadService = shop;

        loadService.load(new Product[5]);
        loadService.load(new Product[5]);
        loadService.load(new Product[5]);

        loadServices[0].load(new Product[4]);
        loadServices[1].load(new Product[4]);
        loadServices[0].load(new Product[4]);
    }
}
