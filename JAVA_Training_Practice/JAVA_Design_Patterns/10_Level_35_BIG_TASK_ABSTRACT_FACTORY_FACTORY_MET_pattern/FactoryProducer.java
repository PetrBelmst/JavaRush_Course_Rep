package com.company;

import com.company.female.FemaleFactory;
import com.company.male.MaleFactory;

public class FactoryProducer {

    public static enum HumanFactoryType {
        MALE, FEMALE;
    }

    public static AbstractFactory getFactory (HumanFactoryType arg) {
        if (arg == HumanFactoryType.MALE) {
            return new MaleFactory();
        } else if (arg == HumanFactoryType.FEMALE) {
            return new FemaleFactory();
        } else return null;
    }
}






