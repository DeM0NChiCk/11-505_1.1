import java.util.Arrays;

public class ExStrings {
    public static void main(String[] args) {
        String strHelloWorld = "Hello World";
        String strHelloWorld1 = "Hello World";

        System.out.println(strHelloWorld);
        String strEx = new String(strHelloWorld1).intern();


        String strHelloWorld2 = new String("Hello World");
        String strHelloWorld3 = new String("Hello World");

        System.out.println(strHelloWorld.equals(strHelloWorld1));
        System.out.println(strHelloWorld.equals(strHelloWorld2));
        System.out.println(strHelloWorld.equals(strEx));

        System.out.println(strHelloWorld == strHelloWorld1 );
        System.out.println(strHelloWorld == strHelloWorld2 );
        System.out.println(strHelloWorld == strEx );


        String str2 = strHelloWorld;

        char[] a = str2.toCharArray();

        for (int i = 0; i < 3; i++) {
            a[i] = (char) ('a' + i);
        }

        String str3 = new String(a);

//        System.out.println(Arrays.toString(a));
//        System.out.println(str3);
//        System.out.println(str3.length());
//        System.out.println(a.length);
//
//        System.out.println(str2 + "!!!!!");
//        System.out.println(strHelloWorld);

        String str4 = "";
        String strNull = null;
        char[] a1 = str4.toCharArray();
        System.out.println(a1.length);
        System.out.println(str4.length());

        char[] a2 = new char[10];
        strHelloWorld.getChars(0, 5, a2, 4 );
        System.out.println(Arrays.toString(a2));

        int res = strHelloWorld2.indexOf("H");
        System.out.println(res);

        strHelloWorld.replaceFirst("l", "L");
        strHelloWorld.replaceFirst("l", "L");

        str2 = strHelloWorld.replaceFirst("l", "L");

        str2 =  strHelloWorld.replaceFirst("l", "L");

        System.out.println(str2);



    }

    public static String ex(String str) {
        return str + "112111";
    }
}
