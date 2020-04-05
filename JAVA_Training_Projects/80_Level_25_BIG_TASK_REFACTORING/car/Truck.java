package com.company.car;

public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
}


/*
Рефакторинг (12)
@Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
 */

/*
Рефакторинг (10)
public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(TRUCK, numberOfPassengers);
    }
}
 */