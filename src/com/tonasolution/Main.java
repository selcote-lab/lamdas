package com.tonasolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    new Thread(
	            () -> {
                    System.out.println("Printing from the Runnable");
                    System.out.println("Line 2");
                    System.out.println("Line 3");
                    System.out.format("This is line %d\n", 4);
                }).start();

	    Employee zouhaire = new Employee("zouhaire", 29);
	    Employee ali = new Employee("Ali", 28);

        List<Employee> employees = new ArrayList<>();
        employees.add(zouhaire);
        employees.add(ali);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee emp1, Employee emp2) {
//                return emp1.getName().compareTo(emp2.getName());
//            }
//        });
        Collections.sort(employees, (Employee emp1, Employee emp2) -> {
            return emp1.getName().compareTo(emp2.getName());
        });

        for(Employee employee: employees){
            System.out.println(employee.getName());
        }
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
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

