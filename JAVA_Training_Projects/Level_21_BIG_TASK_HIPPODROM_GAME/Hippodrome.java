package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Hippodrome {

    static Hippodrome game;

    private List<Horse> horses = new ArrayList<>();

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double max = 0;
        Horse horseMax = null;
        for (Horse horse : horses) {
            if (Math.floor(horse.getDistance()) > max) {
                max = Math.floor(horse.getDistance());
            }
        }
        for (Horse horse : horses) {
            if (Math.floor(horse.getDistance()) >= max)
                horseMax = horse;
        }
        return horseMax;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main(String[] args) {
	// write your code here
        game = new Hippodrome(new ArrayList<>());
        Horse june = new Horse("june", 3, 0);
        Horse july = new Horse("july", 3, 0);
        Horse may = new Horse("may", 3, 0);
        game.getHorses().add(june);
        game.getHorses().add(july);
        game.getHorses().add(may);
        game.run();
        game.printWinner();
    }
}
