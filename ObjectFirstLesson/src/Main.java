public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TestClass testClass = new TestClass("Test1", "test class");
        TestClass testClass2 = new TestClass("Test1", "test class");

        System.out.println(testClass.equals(testClass2));

        System.out.println(testClass);
        System.out.println(testClass2);

        TestClass testClassForEquals1 = testClass;
        TestClass testClassForEquals2 = testClass;

        long valLong = 2L;
        Integer value = 1;
        value = (int) valLong;
        int val = 2;

        value = val;

        String str = "123";

        val = Integer.parseInt(str);
        value = Integer.parseInt(str);


//        int[] test1 = new int[] {1,2,3};
//        int[] test2 = new int[] {1,2,3};
//
//        int[] test3 = test1;
//
//        System.out.println(test1.equals(test2));
//        System.out.println(test1.equals(test3));

        System.out.println(testClass.equals(testClass2));

        System.out.println(testClassForEquals1.equals(testClassForEquals2));

    }
}