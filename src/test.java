import java.util.Arrays;
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

        int[] elem = {1,2,3,4,5,6};

        int c = 0;
        for (int i = elem.length - 1; i >= 0; i--) {
            elem[c] = elem[i];
            c++;
        }
        for (int j : elem) {
            System.out.println(j);
        }

//        System.out.println(calFac(-5));

        char[][] chessBoard = new char[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    chessBoard[i][j] = 'W'; // Белый
                } else {
                    chessBoard[i][j] = 'B'; // Черный
                }
            }
        }

        System.out.println(Arrays.deepToString(chessBoard));
//        System.out.println(Arrays.deepToString(chessGet(new String[8][8])));

        pal();

        v3_n4();

        int[] array = {24,13,52,35,5,325,3,25,33,454};
        int result = 0;
        for(int i = 0; i < array.length; i++) {
            if(result >= array[i]) {
                result = array[i];
            }
        }
        System.out.println(result);

        System.out.println(fun2("I love SQL, I need to learn SQL well."));

        String text = "Programming in Java is fun";
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch>='A' && ch<='Z') {
                ch = (char) (ch+32);
            }
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("Количество гласных: " + count);
    }

    public static int calFac(int n) {
        if (n==0 | n==1) {
            return 1;
        } else {
            return n * calFac(n-1);
        }
    }

//    public static String[][] chessGet (String [][] chessBoard) {
//        int num = 2;
//        for (int i = 0; i < chessBoard.length; i++) {
//            for (int j = 0; j < chessBoard[i].length; j++) {
//               if (num % 2 == 0) {
//                   chessBoard[i][j] = "W";
//               } else {
//                   chessBoard
//               }
//            }
//        }
//
//        return chessBoard;
//    }

    public static void pal() {
        String palindrome = "А роза упала на лапу Азора";
        String processed = palindrome.toLowerCase().replace(" ", "");
        int s = processed.length()/2;
        int r = 0;
        for (int i = 0; i <= s; i++) {
            for (int j = processed.length() - 1; j >= s; j--) {
                if (processed.charAt(j) == processed.charAt(i)) {
                    r = r+1;
                } else {
                    System.out.println("не равен");
                }
            }
        }
        if (r==s) {
            System.out.println("palindrom");
        } else {
            System.out.println("net");
        }
    }

    public static void v3_n4() {
         int[] nums = {1,7,4,2,10,9,6};
         int startI = 0;
         int endI = nums.length - 1;
         for (int i = 0; i<nums.length/2;i++) {
             int a = nums[startI];
             nums[startI] = nums[endI];
             nums[endI] = a;
             startI++;
             endI--;
         }
        System.out.println(Arrays.toString(nums));
    }

    public static String fun2(String sentance) {
        String result = " ";
        String[] sent2 = sentance.split("\\s(\\s)*");

        for (String world: sent2) {
            if (world.equals("SQL")) {
                result = result + "Java" + " ";
            } else {
                result = result + world + " ";
            }
        }

        return result.strip();
    }


}
