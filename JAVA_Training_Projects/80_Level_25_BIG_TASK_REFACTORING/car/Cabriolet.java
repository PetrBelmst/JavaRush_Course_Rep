package com.company.car;

public class Cabriolet extends Car {

    public Cabriolet(int numberOfPassengers) {
        super(CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }
}

/*
Рефакторинг (12)
@Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }
 */

/*
Рефакторинг (10)
public class Cabriolet extends Car {

    public Cabriolet(int numberOfPassengers) {
        super(CABRIOLET, numberOfPassengers);
    }
}
 */