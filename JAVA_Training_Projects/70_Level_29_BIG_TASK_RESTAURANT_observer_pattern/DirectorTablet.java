package com.company;

import com.company.ad.Advertisement;
import com.company.ad.StatisticAdvertisementManager;
import com.company.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    private StatisticManager statisticManager = StatisticManager.getInstance();

    public void printAdvertisementProfit() {
        Map<Date, Double> advStatResult = StatisticManager.getInstance().getAdvStatistic();

        double amount = 0.00;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<Date, Double> element : advStatResult.entrySet()) {
            System.out.println(simpleDateFormat.format(element.getKey()) + " - " + String.format(Locale.ENGLISH, "%(.2f", element.getValue()));
            amount += element.getValue();
        }
        ConsoleHelper.writeMessage("Total - " + String.format(Locale.ENGLISH, "%(.2f", amount));

    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookStatResult = statisticManager.getCooksStatistic();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (Map.Entry<Date, Map<String, Integer>> entry : cookStatResult.entrySet()) {
            Date currDate = entry.getKey();
            ConsoleHelper.writeMessage(dateFormat.format(currDate));

            Map<String, Integer> cookList = entry.getValue();

            for (Map.Entry<String, Integer> cookEntry : cookList.entrySet()) {
                if (cookEntry.getValue() == 0) {
                    continue;
                }
                String cookName = cookEntry.getKey();
                Integer workingTimeInMinutes;
                if (cookEntry.getValue() % 60 == 0) {
                    workingTimeInMinutes = cookEntry.getValue() / 60;
                } else {
                    workingTimeInMinutes = cookEntry.getValue() / 60 + 1;
                }
                ConsoleHelper.writeMessage(cookName + " - " + workingTimeInMinutes + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getActiveVideos();
        List<String> list = new ArrayList<>(videos.keySet());
        Collections.sort(list);
        for (String s : list) {
            ConsoleHelper.writeMessage(s + " - " + videos.get(s));
        }
    }

    public void printArchivedVideoSet() {
        Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getArchivedVideos();
        List<String> list = new ArrayList<>(videos.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        for (String s : list) {
            ConsoleHelper.writeMessage(s);
        }

    }

    private void videosSorting(List<Advertisement> videosList) {

    }
}