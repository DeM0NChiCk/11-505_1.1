import java.util.Arrays;

public class StringsLesson {
    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";

        String s3 = new String("Java");

        String s4 = null;

//        System.out.println("afqwfwef".concat(s1));

        String name = "Ayrat";
        String name2 = "Ayrat";

//        if (name.equals(name2)){ //Валиуллин Айрат
//            System.out.println("имена одинаковы");
//        } else {
//            System.out.println("имена не равны");
//        }

//        String s5 = "dcjanskdjckdhbksjfdhkvjdshfkjhfdjkkhkj AKHDBFGNdfv";Каримова Айсина
//        String s6 = "GGKKLn";
//        String s6 = "dcjan";
//        String s6 = "Ndfv";
//        if (s5.startsWith(s6)){
//            System.out.println("s6 входит в начало s5");
//        } else {
//            System.out.println("s6 не входит в начало s5");
//        }
//        if (s5.endsWith(s6)){
//            System.out.println("s6 входит в конец s5");
//        } else {
//            System.out.println("s6 не входит в конец s5");
//        }
//        myshkovMisha();
//        kirilNaumov();


        String text = " ssssssssssss 505,   the best aaaaaa   ";
        String[] wordsBase = text.split(" ");
        String[] wordsBases = text.split(",");
        String[] words = text.split("\\s*(\\s|,|!|\\.|-)\\s*"); // 0 \\s 1 , 4 \\s
//        System.out.println(Arrays.toString(words));
//        System.out.println("_________________________");
//        System.out.println(Arrays.toString(wordsBase));
//        System.out.println("_________________________");
//        System.out.println(Arrays.toString(wordsBases));

        String ex = "505!!!!!!!!!!the!!!!!!best";
        String[] wordsEx = ex.split("!");
        String[] wordsEx1 = ex.split("!*");
        String[] wordsEx2 = ex.split("!*(!)!*");
        System.out.println("_________________________");
        System.out.println(Arrays.toString(wordsEx) + " : ex.split(\"!\")");
        System.out.println("_________________________");
        System.out.println(Arrays.toString(wordsEx1) + " : ex.split(\"!*\")");
        System.out.println("_________________________");
        System.out.println(Arrays.toString(wordsEx2) + " : ex.split(\"!*(!)!*\")");

        // TODO: ТЫ КТО?
        String a = "Какой у вас аркан?";
        String b = "аоу";
        int res = 0;
        for( int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (b.indexOf(ch) > -1) {
                res++;

            }
        }
        System.out.println(res);
    }




    public static void myshkovMisha(){
        String s1 = "      aefaeffewfwewef qeffewfwefew  wewe SDSAdasdsaf";
        int index = s1.indexOf(" wewe ")+1;
        System.out.println(s1.substring(index, index+4));
    }

    public static void kirilNaumov(){
        String s1 = "      aefaeffewfwewef qeffewfwefew  wewe SDSAdasdsaf";
        String s2 = s1.strip();
        String s3= s2.toLowerCase();
        String s4 = s3.toUpperCase();
        String s5 = "";
        String s6 = "";
        String s7 = "";
        char [] array = s4.toCharArray();
        int index = s4.indexOf("SDSA");
        int index2 = s4.indexOf("DASDSAF");
        int index3 = s4.indexOf("SDSA");
        for (int i = 0;i < index;i++){
            s5 += array[i];
        }
        for(int i = index2;i < s4.length();i++){
            s6 += array[i];
        }
        for(int i =index3;i < index3 + 4;i++){
            s7 += array[i];
        }

        String lowerCaseStr =s5.toLowerCase();
        String lowerCaseStr2 =s6.toLowerCase();

        System.out.println(lowerCaseStr + s7 + lowerCaseStr2);


    }

}
