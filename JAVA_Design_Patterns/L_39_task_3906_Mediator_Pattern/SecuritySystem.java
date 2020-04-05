package com.company;

public class SecuritySystem implements Switchable{
    private boolean on = false;

    public boolean isOn() {
        return on;
    }

    public void turnOff() {
        System.out.println("Turning off the SecuritySystem!");
        on = false;
    }

    public void turnOn() {
        System.out.println("Turning on the SecuritySystem!");
        on = true;
    }
}
