package model;

public class User {

    private int id;
    private String username;
    private String country;
    private int age;
    private Account account;

    public User(int id, String country, int age, String username, String login, String password) {
        this.id = id;
        this.username = username;
        this.country = country;
        this.age = age;
        this.account = new Account(login, password.length());
    }

    public User(){}

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void print() {
        System.out.println(account.print() + "\nUsername: " + username);
    }

    public class Account{
        private String username;
        private int hashPassword;

        private Account(String login, int hashPassword) {
            this.hashPassword = hashPassword;
            this.username = login;
            if (User.this.username.equals(" ")) {
                User.this.username = login;
            }
        }

        private String print() {
            return "Login: " + username;
        }
    }
}
