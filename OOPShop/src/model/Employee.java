package model;

public class Employee extends User{

    private int tabelNumber;
    private String job;
    private String department;

    public Employee(
            String country,
            int age,
            String username,
            String login,
            String password,
            int tabelNumber,
            String job,
            String department) {
        super(country, age, username, login, password);
        this.job = job;
        this.tabelNumber = tabelNumber;
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public int getTabelNumber() {
        return tabelNumber;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public int getId() {
        return getTabelNumber();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Job: " + getJob());
    }

    static void instanceofEmployee(User user) {
        if (user instanceof Employee employee1) {

            Employee employee = (Employee) user;
            System.out.println("Employee have job " + employee.getJob());
            System.out.println("Employee have job " + employee1.getJob());
            System.out.println("Employee have job " + ((Employee) user).getJob());
        } else {
            System.out.println("This is user not employee");
        }

    }
}
