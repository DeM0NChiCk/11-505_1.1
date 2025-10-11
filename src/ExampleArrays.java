import java.util.Arrays;

public class ExampleArrays {
    public static void main(String[] args) {


        int[] arr1 = new int[12];
        int[] arr2 = arr1;

        int[] arr3;

        System.out.println(arr1.length);
        System.out.println(arr1[0]);
        System.out.println(arr1);
        System.out.println(arr2);

        for (int i = 0; i <= arr1.length -1 ; i++) {
            arr1[i] = i + 1;
            System.out.print("i = " + i + "\t");
            System.out.println("arr1[i] = " + arr1[i]);
        }

        for (int i = 0; i <= arr2.length - 1 ; i++) {
            arr2[i] = i + 2;
            System.out.print("i =" + i + "\t");
            System.out.println("arr2[i] = " + arr2[i]);
        }

        System.out.println("arr1[1]" + arr1[1]);
        System.out.println("arr2[1]" + arr2[1]);

        arr2 = new int[12];

        for (int i = 0; i <= arr2.length - 1 ; i++) {
            arr2[i] = i + 3;
            System.out.print("i =" + i + "\t");
            System.out.println("arr2[i] = " + arr2[i]);
        }


        System.out.println("arr1[1]" + arr1[1]);
        System.out.println("arr2[1]" + arr2[1]);

        System.out.println(Arrays.toString(new int[10]));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(new int[10]));

        int[][] arrM1 = {
                {0,1,2},
                {3,4,5}
        };

        int[][][] arrMM2 = {
                {
                    {0,1}, {0,2}
                },
        };

        for(int i = 0; i < arrM1.length ; i++) {
            System.out.println(Arrays.toString(arrM1[i]));
            for (int j = 0; j < arrM1[i].length; j++) {
                System.out.println(arrM1[i][j] + "\t");

            }
        }

        System.out.println(Arrays.toString(arrM1));

        System.out.println(Arrays.deepToString(arrM1));

        int[][] ex1 = new int[5][10];
        int[]   ex2 = new int[10];

        System.out.println("------------------------------");
        System.out.println("0" + Arrays.deepToString(ex1));

        for (int[] values : ex1) {
            System.out.println("values1:" + values);

            values[1] = 1;
            System.out.println("values2:" + values);
        }

        System.out.println("1" + Arrays.deepToString(ex1));
        System.out.println("------------------------------");

        for (int[] values : ex1) {
            System.out.println("values1:" + values);
            ex1[0] = ex2;

            System.out.println(values.equals(ex1[0]));
        }
        System.out.println("2" + Arrays.deepToString(ex1));
        System.out.println("------------------------------");

        for (int[] values : ex1) {
            System.out.println("values1:" + values);
        }
        System.out.println("3" + Arrays.deepToString(ex1));





    }

}
