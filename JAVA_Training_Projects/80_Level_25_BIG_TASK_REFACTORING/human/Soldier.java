package com.company.human;

public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
            fight();
    }

    public void fight() {
    }

}


/*
Рефакторинг (2)
public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
            fight();
    }

    public void fight() {
    }
 */