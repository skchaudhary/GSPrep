package com.gs.string;

import java.util.HashSet;

public class ReverseStringBug {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();

        Employee emp4 = new Employee("Sanjay", 10);
        Employee emp5 = new Employee("Sanjay", 10);
        Employee emp6 = new Employee("Sanjay", 10);

        HashSet<Employee> hs = new HashSet<>();
        hs.add(emp1);hs.add(emp2);hs.add(emp3);
        hs.add(emp4);hs.add(emp5);hs.add(emp6);

        System.out.println(emp1.equals(emp2));
        System.out.println(hs.size());

        StringBuffer sb =new StringBuffer();
        sb.delete(0, sb.length());
    }
}

class Employee {
    private String name;
    private int age;
    public Employee(){

    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
