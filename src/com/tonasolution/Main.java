package com.tonasolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Employee zouhaire = new Employee("zouhaire", 29);
	    Employee ali = new Employee("Ali", 28);

        List<Employee> employees = new ArrayList<>();
        employees.add(zouhaire);
        employees.add(ali);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        for(Employee employee: employees){
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
////            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

//        for (int i=0; i< employees.size(); i++){
//            Employee e = employees.get(i);
//            new Thread(() -> System.out.println(e.getAge())).start();
//        }

    }
    public static String doStringStuff(
            UpperAndConcat upperAndConcat,
            String s1,
            String s2
    ){
        return upperAndConcat.upperAndConcat(s1, s2);
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

interface UpperAndConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething(){
        int i=0;
        UpperAndConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("I = " + i);
            return s1.toUpperCase() + s2.toUpperCase();
        } ;

        System.out.println("The another class's name " + getClass().getSimpleName());
        System.out.println("i = " + i);
        return Main.doStringStuff(uc, "String1", "String2");
    }

    public void printValue(){
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println( number );
        };

        new Thread(r).start();
    }
}