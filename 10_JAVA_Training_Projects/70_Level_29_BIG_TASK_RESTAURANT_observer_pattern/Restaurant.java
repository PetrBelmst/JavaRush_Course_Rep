package com.company;

import com.company.kitchen.Cook;
import com.company.kitchen.Order;
import com.company.kitchen.Waiter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);

        Waiter waiter = new Waiter();

        List<Cook> cookList = new LinkedList<>();
        for (int i = 1; i < 3; i++) {
            Cook cook = new Cook("Amigo" + i);
            cookList.add(cook);
            cook.addObserver(waiter);
            cook.setQueue(orderQueue);
            Thread cookThread = new Thread(cook);
            cookThread.start();
        }

        List<Tablet> tabletList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tabletList.add(tablet);
        }

        DirectorTablet directorTablet = new DirectorTablet();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
        thread.interrupt();

        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();

    }
}
