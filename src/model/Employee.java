package model;

public class Employee {
    private String name;            //họ tên
    private int age;                //tuổi
    private String address;         //địa chỉ

    public Employee(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + "\t\t\t " + age + " tuổi\t\t\t " + address;
    }
}
