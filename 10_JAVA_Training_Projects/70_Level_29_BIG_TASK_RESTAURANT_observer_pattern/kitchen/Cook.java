package com.company.kitchen;

import com.company.ConsoleHelper;
import com.company.statistic.StatisticManager;
import com.company.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {

    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;
    private boolean stopped = false;
    private boolean caught = false;


    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time "
                + order.getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
        StatisticManager statisticManager = StatisticManager.getInstance();
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow
                (order.getTablet().toString(), name, order.getTotalCookingTime(), order.getDishes());
        statisticManager.register(cookedOrderEventDataRow);

        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public void run() {
        while (!stopped) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
            if (queue.peek() != null) {

                if (!this.isBusy()) {
                    try {
                        Order order = queue.take();
                        if (order != null) {
                            startCookingOrder(order);
                        }
                    } catch (InterruptedException e) {
                        caught = true;
                    }
                }
            }
            if (caught && queue.isEmpty()) {
                stopped = true;
            }
        }
    }
}
