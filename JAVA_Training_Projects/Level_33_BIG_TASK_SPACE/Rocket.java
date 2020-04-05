package com.company;


 //Класс для объектов-ракета

public class Rocket extends BaseObject {

    public Rocket(double x, double y) {
        super(x, y, 1);
    }

     // рисует свой объект на "канвасе".
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'R');
    }

    // вверх на один ход.
    @Override
    public void move() {
        y--;
    }
}
