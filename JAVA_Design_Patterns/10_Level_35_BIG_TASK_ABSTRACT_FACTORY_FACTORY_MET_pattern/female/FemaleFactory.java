package com.company.female;

import com.company.AbstractFactory;
import com.company.Human;

public class FemaleFactory implements AbstractFactory {

    public Human getPerson (int age) {
        if (age <= 12) {
            return new KidGirl();
        } else if (age > 12 && age <= 19) {
            return new TeenGirl();
        } else {
            return new Woman();
        }
    }
}
