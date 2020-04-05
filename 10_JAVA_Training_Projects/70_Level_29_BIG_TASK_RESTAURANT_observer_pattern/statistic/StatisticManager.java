package com.company.statistic;

import com.company.statistic.event.CookedOrderEventDataRow;
import com.company.statistic.event.EventDataRow;
import com.company.statistic.event.EventType;
import com.company.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {

    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<Date, Double> getAdvStatistic() {
        Map<Date, Double> resultAdvStat = new TreeMap<>(Comparator.reverseOrder());
        List<EventDataRow> advList = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        for (EventDataRow e : advList) {
            Date currentDate = e.getDate();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTime(currentDate);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            double paidAmount = ((VideoSelectedEventDataRow) e).getAmount() / 100.00;
            if (resultAdvStat.containsKey(calendar.getTime())) {
                paidAmount += resultAdvStat.get(calendar.getTime());
            }
            resultAdvStat.put(calendar.getTime(), paidAmount);
        }
        return resultAdvStat;
    }

    public Map<Date, Map<String, Integer>> getCooksStatistic() {
        Map<Date, Map<String, Integer>> resultCooksStat = new TreeMap<>(Collections.reverseOrder());
        List<CookedOrderEventDataRow> cookEventList = new ArrayList<>();
        for (EventDataRow eventDataRow : statisticStorage.getStorage().get(EventType.COOKED_ORDER)) {
            cookEventList.add((CookedOrderEventDataRow) eventDataRow);
        }

        for (CookedOrderEventDataRow eventDataRow : cookEventList) {
            Date eventDate = eventDataRow.getDate();

            Date currEventDate = new Date(0);
            currEventDate.setYear(eventDate.getYear());
            currEventDate.setMonth(eventDate.getMonth());
            currEventDate.setDate(eventDate.getDate());

            String cookName = eventDataRow.getCookName();
            int cookingDuration = eventDataRow.getTime();

            if (resultCooksStat.containsKey(currEventDate)) {
                Map<String, Integer> currDateMap = resultCooksStat.get(currEventDate);
                Map<String, Integer> tempDateMap = new TreeMap<>(currDateMap);

                if (tempDateMap.containsKey(cookName)) {
                    int workingTimePerDay = tempDateMap.get(cookName);
                    workingTimePerDay += cookingDuration;
                    tempDateMap.put(cookName, workingTimePerDay);

                } else {
                    tempDateMap.put(cookName, cookingDuration);
                }

                resultCooksStat.put(currEventDate, tempDateMap);

            } else {
                Map<String, Integer> currDateMap = new TreeMap<>();
                currDateMap.put(cookName, cookingDuration);
                resultCooksStat.put(currEventDate, currDateMap);
            }
        }

        return resultCooksStat;
    }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
