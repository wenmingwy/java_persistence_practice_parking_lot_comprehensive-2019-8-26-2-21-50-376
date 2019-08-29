package tws.entity;

import java.io.Serializable;

public class Employee implements Serializable {
    private int employeeID;
    private String name;
    private String age;

    public Employee() {

    }

    public Employee(int employeeID, String name, String age) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
