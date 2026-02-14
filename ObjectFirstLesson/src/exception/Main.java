package exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        try {
//            FileInputStream file = new FileInputStream("file.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//            // Вместо e мы можем указать любое своё сообщение. Но нудно быть острожным в конкретности ошибки.
//        }

        Scanner scr = new Scanner(System.in);

        int a = scr.nextInt();
        int b = scr.nextInt();
        int age = scr.nextInt();

        try {
            validateAge(age);
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
        }

        try {
            int result = divide(a, b);
            print("Результат деления: " + result);
        } catch (ArithmeticException e) {
//            throw new ArithmeticException("Ошибка! Деление на нуль.");
            print("Ошибка! Деление на нуль." + e.toString());
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
        }
        finally {
            print("Спасибо, что выбираете нас!");
        }
        int res = divide(10, 5);
        print("res: " + res);



        Throwable throwable = new Throwable();

        Error error = new Error();
        Exception exception = new Exception();
        RuntimeException runtimeException = new RuntimeException();

    }

    private static int divide(int a, int b) throws ArithmeticException, NullPointerException {
        return a / b;
    }

    static void print (String mes) {
        System.out.println(mes);
    }

    static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст должен быть больше 17");
        }
    }

}