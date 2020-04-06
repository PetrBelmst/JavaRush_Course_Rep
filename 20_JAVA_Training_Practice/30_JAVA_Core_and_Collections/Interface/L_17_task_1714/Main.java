package com.company;
/*
Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться
нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число, которое
показывает что первый пляж лучше (положительное число)
или второй пляж лучше (отрицательное число), и насколько он лучше.
Требования:
•	Класс Beach должен содержать три поля: String name, float distance, int quality.
•	Класс Beach должен реализовывать интерфейс Comparable<Beach>.
•	Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
•	Все методы класса Beach, кроме метода main, должны быть синхронизированы.
*/

public class Main implements Comparable<Main> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Main (String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Main o) {
        int a = (int) (this.distance * this.quality);
        int b = (int) (o.getDistance()*o.getQuality());
        int c = a -b;
        return c;
    }

    public static void main(String[] args) {

    }
}
