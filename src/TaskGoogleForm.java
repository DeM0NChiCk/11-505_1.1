import java.util.Scanner;

public class TaskGoogleForm {
    public static void main(String[] args) {
        String[] fields = {"nickname", "age", "profession", "email", "address", "inst"};
        String[][] users = new String[5][fields.length];
        // Scanner = name, age, profession, email, address, inst
        Scanner scanner = new Scanner(System.in);

        String longestName = "";
        int sumAge = 0;
        char[][] emails = new char[5][];
        String[] profsList = new String[5];
        int diffProfs = 0;


        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            users[i] = new String[fields.length];
            String nickname = scanner.next();
            int age = scanner.nextInt();
            String profession = scanner.next();
            String email = scanner.next();
            String address = scanner.next();
            String inst = scanner.next();
            scanner.nextLine();

            System.out.print(nickname + " " + age + " " + profession + " " + email + " " + address + " " + inst + "\n");

            //
            sumAge += age;
            //
            if (longestName.length() < nickname.length()) {
                longestName = nickname;
            }
            //
            boolean flag = true;
            for (String prof : profsList) {
                if (prof.equals(profession)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                diffProfs += 1;
                profsList[diffProfs] = profession;
            }
            //
            char[] new_email = new char[email.length()];
            for (int j = 0; j < email.length(); j++) {
                char[] charEmail = email.toCharArray();
                if (charEmail[j] == '@') {
                    break;
                }
                new_email[j] = email.charAt(j);
            }
        }


        System.out.println(longestName);
        System.out.println(sumAge / 5);

        for (int i = 0; i < emails.length; i++) {
            for (int j = 0; j < emails[i].length; j++) {
                System.out.print(emails[i][j]);
            }
            System.out.println();
        }
        System.out.println(diffProfs);
    }
}
