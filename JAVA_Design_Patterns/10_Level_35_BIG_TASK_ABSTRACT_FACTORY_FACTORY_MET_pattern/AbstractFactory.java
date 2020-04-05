package com.company;

import com.company.male.KidBoy;
import com.company.male.Man;
import com.company.male.TeenBoy;

public interface AbstractFactory {

    public Human getPerson (int age);

}
