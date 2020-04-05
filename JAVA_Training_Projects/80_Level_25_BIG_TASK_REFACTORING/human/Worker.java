package com.company.human;

public class Worker extends Human{

    private double salary;
    private String company;

    public Worker(String name, int age) {
        super(name, age);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void live() {

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

/*
Рефакторинг (9)
private String company;
public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
 */

/*
Рефакторинг (2)
public Worker(String name, int age) {
        human = new Human(name, age);
    }
 */


/*
public class Worker {
    private Human human;
    private double salary;
    public String company;

    public Worker(String name, int age) {
        human = new Human(false);
    }

    public void live() {
        human.live();
    }

    public double getSalary() {
        return salary;
    }

    public void setSlr(double salary) {
        this.salary = salary;
    }
}
 */