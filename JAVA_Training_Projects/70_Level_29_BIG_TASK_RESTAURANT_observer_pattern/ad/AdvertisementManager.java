package com.company.ad;

import com.company.ConsoleHelper;
import com.company.statistic.StatisticManager;
import com.company.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {

    private int timeSeconds;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        Set<Set<Advertisement>> parentSet = getResultSet(new HashSet<>());

        Set<Advertisement> toBePlayedTemp = new HashSet<>();

        int maxSum = 0;

        Set<Set<Advertisement>> sumSet = new HashSet<>();
        for (Set<Advertisement> s : parentSet) {
            int currSum = sum(s);
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        for (Set<Advertisement> s : parentSet) {
            if (sum(s) == maxSum) {
                sumSet.add(s);
            }
        }

        int maxTime = 0;
        int minCount = 0;
        Set<Set<Advertisement>> maxTimeSet = new HashSet<>();
        if (sumSet.size() > 1) {
            for (Set<Advertisement> s : sumSet) {
                int currTime = time(s);
                if (currTime > maxTime) {
                    maxTime = currTime;
                }
            }
            for (Set<Advertisement> s : sumSet) {
                if (time(s) == maxTime) {
                    maxTimeSet.add(s);
                }
            }

            if (maxTimeSet.size() > 1) {
                for (Set<Advertisement> s : maxTimeSet) {
                    if (minCount == 0) {
                        minCount = s.size();
                        toBePlayedTemp = s;
                    } else {
                        if (s.size() < minCount) {
                            minCount = s.size();
                            toBePlayedTemp = s;
                        }
                    }
                }
            } else {
                toBePlayedTemp = maxTimeSet.iterator().next();
            }
        } else {
            toBePlayedTemp = sumSet.iterator().next();
        }

        List<Advertisement> advToBePlayed = new ArrayList<>();
        advToBePlayed.addAll(toBePlayedTemp);
        Collections.sort(advToBePlayed, (o1, o2) -> {
            if ((o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying()) == 0) {
                return (int) (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
            } else {
                return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advToBePlayed, maxSum, maxTime));

        for (Advertisement a : advToBePlayed) {
            ConsoleHelper.writeMessage(a.getName() + " is displaying... "
                    + a.getAmountPerOneDisplaying()
                    + ", " + a.getAmountPerOneDisplaying() * 1000 / a.getDuration());
            a.revalidate();
        }

    }

    public int sum(Set<Advertisement> set) {
        int sum = 0;
        if (set.size() == 0) {
            return 0;
        } else {
            for (Advertisement a : set) {
                sum += a.getAmountPerOneDisplaying();
            }
        }
        return sum;
    }

    public int time(Set<Advertisement> set) {
        int currentTime = 0;
        if (set.size() == 0) {
            return 0;
        } else {
            for (Advertisement a : set) {
                currentTime += a.getDuration();
            }
        }
        return currentTime;
    }

    public boolean isAppropriate(Set<Advertisement> set, Advertisement a) {
        return ((time(set) + a.getDuration() <= timeSeconds) && !set.contains(a) && a.getHits() >= 1);
    }

    public Set<Advertisement> getCopy(Set<Advertisement> set) {
        Set<Advertisement> copy = new HashSet<>();
        copy.addAll(set);
        return copy;
    }

    public Set<Set<Advertisement>> getResultSet(Set<Advertisement> list) {
        boolean flag = true;
        Set<Set<Advertisement>> resultSet = new HashSet<>();

        for (Advertisement a : storage.list()) {
            if (isAppropriate(list, a)) {
                Set<Advertisement> tempSet = getCopy(list);
                tempSet.add(a);
                resultSet.addAll(getResultSet(tempSet));
                flag = false;
            }
        }
        if (flag) {
            resultSet.add(list);
        }
        return resultSet;
    }
}