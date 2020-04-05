package com.company.male;

import com.company.AbstractFactory;
import com.company.Human;

public class MaleFactory implements AbstractFactory {

    public Human getPerson (int age) {

        if (age <= 12) {
            return new KidBoy();
        } else if (age > 12 && age <= 19) {
            return new TeenBoy();
        } else {
            return new Man();
        }
    }
}
