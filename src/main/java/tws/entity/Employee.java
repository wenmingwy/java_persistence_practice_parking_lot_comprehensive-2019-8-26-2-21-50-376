package tws.entity;

import java.io.Serializable;

public class Employee implements Serializable {
    private int employeeID;
    private String name;
    private int age;

    public Employee() {

    }

    public Employee(int employeeID, String name, int age) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return employeeID;
    }

    public void setId(int id) {
        this.employeeID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
