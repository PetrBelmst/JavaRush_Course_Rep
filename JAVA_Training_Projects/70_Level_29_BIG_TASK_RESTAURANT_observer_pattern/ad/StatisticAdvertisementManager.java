package com.company.ad;

import java.util.*;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager instance;
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {}

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }

    public Map<String, Integer> getActiveVideos() {
        Map<String, Integer> result = new HashMap<>();
        List<Advertisement> videos = advertisementStorage.list();

        for(Advertisement a : videos)
        {
            if(a.getHits() > 0)
                result.put(a.getName(), a.getHits());
        }

        return result;
    }

    public Map<String, Integer> getArchivedVideos() {
        Map<String, Integer> result = new HashMap<>();
        List<Advertisement> videos = advertisementStorage.list();

        for(Advertisement a : videos)
        {
            if(a.getHits() <= 0)
                result.put(a.getName(), a.getHits());
        }

        return result;
    }
}















