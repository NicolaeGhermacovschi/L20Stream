package model;

import java.util.Objects;

public class Employee {
    private  String name;
    private Department department;
    private int age;
    private boolean isPayedPerHour;

    public Employee() {
    }

    public Employee(String name, Department department, int age, boolean isPayedPerHour) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.isPayedPerHour = isPayedPerHour;
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

    public boolean isPayedPerHour() {
        return isPayedPerHour;
    }

    public void setPayedPerHour(boolean payedPerHour) {
        isPayedPerHour = payedPerHour;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", age=" + age +
                ", isPayedPerHour=" + isPayedPerHour +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && isPayedPerHour == employee.isPayedPerHour && Objects.equals(name, employee.name) && department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, age, isPayedPerHour);
    }
}
