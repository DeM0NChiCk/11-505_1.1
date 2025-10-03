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

    }

}
