import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int redP = sc.nextInt();
        int greenP = sc.nextInt();
        int orangeP = sc.nextInt();

        if (redP > greenP) {
            if (redP > orangeP) {
                System.out.println("Красных больше всего");
            }
        } else {
            if ((greenP > redP) && (greenP > orangeP)) {
                System.out.println("Зелёных больше всех");
            } else {
                System.out.println("Оранжевых больше всех");
            }
        }

        System.out.println("итого" + redP + greenP + orangeP);


    }
}
