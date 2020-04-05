package com.company;

public class ElectricPowerSwitch {
    private Switchable securitySystem;

    public ElectricPowerSwitch(Switchable securitySystem) {
        this.securitySystem = securitySystem;
    }

    public void press() {
        System.out.println("Power switch flipped.");
        if (securitySystem.isOn()) {
            securitySystem.turnOff();
        } else {
            securitySystem.turnOn();
        }
    }
}