import java.util.Arrays;

public class FuncEx {
    public static void main(String[] args) {
        int a = 100;
        int b = 20;
        int c = a + b;
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("main: " + c);
        print(20, 30);
        print("Мышков: " + sqr(a));
        print("Каримова " + maxx(a, b));
        print("Алякина" + sr(array));
        print("Николаев" + Arrays.toString(randomIntMassive(6)));
        print("Колосов: ");
        printArray(randomIntMassive(6));
        print("\n");
        print("Муллахметов" + Arrays.deepToString(createMatrix(3,3)));



    }

    public static void print(int a, int b) {
        int c = a + b;
        System.out.println("print: " + c);
    }

    public static int sqr(int a) {
        return a * a;
    }

    public static void print(String a) {
        System.out.println(a);
    }

    public static int maxx(int a1, int a2) {
        if (a1 > a2) return a1;
        return a2;
    }

    public static double sr(int[] array) {
        double sr_z = 0;
        for (int i = 0; i < array.length; i++) {
            sr_z += array[i];
        }
        sr_z /= array.length;
        return sr_z;
    }

    public static int[] randomIntMassive(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        int numbers = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            numbers = arr[i];
            System.out.print(numbers);
        }
    }

    public static int[][] createMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
        return matrix;
    }
}
