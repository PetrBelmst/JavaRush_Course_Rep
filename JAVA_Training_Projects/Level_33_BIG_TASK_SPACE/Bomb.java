package com.company;

 //Класс для бомбы.

public class Bomb extends BaseObject {
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    //Отрисовываем на холсте
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'B');
    }

    //Двигаем вниз на один ход
    @Override
    public void move() {
        y++;
    }
}
