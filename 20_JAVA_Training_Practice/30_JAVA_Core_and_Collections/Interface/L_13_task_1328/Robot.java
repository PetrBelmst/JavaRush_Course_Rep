package com.company;

public class Robot extends AbstractRobot implements Attackable, Defensable {

    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
