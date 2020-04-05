package com.company;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }


    @Override
    public void run() {
        if (tablets.size() > 0) {
            while (!Thread.currentThread().isInterrupted()) {
                Tablet currentTablet = tablets.get((int) Math.round(Math.random() * (tablets.size() - 1)));
                currentTablet.createTestOrder();
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}