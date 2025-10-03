import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        long b;
        int a;
        byte c;

//        while (true) {
//            a = 10;
//        }
        b = 1000000000000L;
        c = 126;

        int i;

        b = 10;

        a = c;

        if ( a < b) {
            System.out.println("a меньше b");
        } else if (a == b) {
            System.out.println("a == b");
        } else {
            System.out.println("b меньше a");
        }

        for (i = 0; i < 5; i++) {
            switch (i) {
                case 1:
                case 2:
                    System.out.println(i);
                    break;
                default:
                    System.out.println("Значения не подходят!");
                    break;
            }
        }

        System.out.println(i);

        switch (a) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("Значения не подходят!");
        }

        a = (int) b;

        System.out.println(a);


        int a1 = 2; //010
        int b1 = 5;//101
        /*
            0 & 1 -> 0
            1 & 0 -> 0
            0 & 1 -> 0

            000 -> 0


         */
        System.out.println(a1&b1); // результат 0

        int a2 = 4; //100
        int b2 = 5; //101

        /*
            1 & 1 -> 1
            0 & 0 -> 0
            1 & 0 -> 0

            100 -> 4

         */
        System.out.println(a2 & b2); // результат 4

        a1 = 6;

        if ( a1 >= 6) {
            System.out.println(a1);
        } else {

        }

        Scanner scan = new Scanner(System.in);
        int exNext =  new Scanner(System.in).nextInt();
        int exNext2 = scan.nextInt();

        String exN = scan.nextLine();
        String exLine = scan.nextLine();

        System.out.printf("Вывод %d %d ", exNext, exNext2);
        System.out.println(exN);
        System.out.println(exLine);

        for (i = 0; i < 5; i++) {
            scan.nextInt();
        }



    }
}