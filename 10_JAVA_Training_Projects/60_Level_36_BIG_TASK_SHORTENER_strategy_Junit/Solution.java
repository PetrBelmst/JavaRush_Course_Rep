package com.company;

import com.company.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> idSet = new HashSet<>();
        for (String element : strings) {
            idSet.add(shortener.getId(element));
        }
        return idSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> stringSet = new HashSet<>();
        for (Long element : keys) {
            stringSet.add(shortener.getString(element));
        }
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testStringSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testStringSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date startTime = new Date();
        Set<Long> setOfId = getIds(shortener, testStringSet);
        Date endTime = new Date();
        long timeForGetIdsMethodExecution = endTime.getTime() - startTime.getTime();
        Helper.printMessage(String.valueOf(timeForGetIdsMethodExecution));

        startTime = new Date();
        Set<String> setOfString = getStrings(shortener, setOfId);
        endTime = new Date();
        long timeForGetStringsMethodExecution = endTime.getTime() - startTime.getTime();
        Helper.printMessage(String.valueOf(timeForGetStringsMethodExecution));

        if (testStringSet.equals(setOfString)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
	// write your code here
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 2000);

        StorageStrategy strategy1 = new OurHashMapStorageStrategy();
        testStrategy(strategy1, 2000);

        StorageStrategy strategy2 = new FileStorageStrategy();
        testStrategy(strategy2, 20);

        StorageStrategy strategy3 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy3, 2000);

        StorageStrategy strategy4 = new HashBiMapStorageStrategy();
        testStrategy(strategy4, 2000);

        StorageStrategy strategy5 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy5, 2000);

    }
}
