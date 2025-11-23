package model;

public class Student {
    private String surname;
    private String name;
    private boolean gender = false;
    private int age;
    private int studBilet;

    {
        gender = true;
    }

    public Student(String surname, String name, boolean gender, int age, int studBilet) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.studBilet = studBilet;
        this.gender = gender;
    }

    public Student(int age, int studBilet){
        this.age = age;
        this.studBilet = studBilet;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudBilet() {
        return studBilet;
    }

    public boolean isGender() {
        return gender;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setStudBilet(int studBilet){
        this.studBilet = studBilet;
    }

    public void setGender(boolean gender){
        this.gender = gender;
    }

}
