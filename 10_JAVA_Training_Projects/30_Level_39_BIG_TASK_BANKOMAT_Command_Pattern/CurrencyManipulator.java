package com.company;

import com.company.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations; // номинал и количество купюр

    public CurrencyManipulator(String currencyCode) {
        denominations = new HashMap<>();
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int totalAmount = denominations.entrySet().stream().mapToInt(entry ->
                (entry.getKey()) * entry.getValue()).sum();
        return totalAmount;
    }

    public boolean hasMoney() {
        if (!denominations.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAmountAvailable(int expectedAmount) {
        if (expectedAmount <= getTotalAmount()) {
            return true;
        } else {
            return false;
        }
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        if (getTotalAmount() < expectedAmount) {
            throw new NotEnoughMoneyException();
        }

        List<Integer> listOfNominal = new ArrayList<>(denominations.keySet());
        Collections.sort(listOfNominal, Comparator.reverseOrder());

        Map<Integer, Integer> copyOfDenominations = new TreeMap<>(Comparator.reverseOrder());
        copyOfDenominations.putAll(denominations);

        Map<Integer, Integer> withdrawMap = new HashMap<>();

        for (int i = 0; i < listOfNominal.size(); ) {
            int nominal = listOfNominal.get(i);
            if (nominal <= expectedAmount && copyOfDenominations.containsKey(nominal) &&
                    copyOfDenominations.get(nominal) > 0) {
                withdrawMap.merge(nominal, 1, (integer, integer2) -> integer + integer2);
                copyOfDenominations.merge(nominal, -1, (integer, integer2) -> integer + integer2);
                expectedAmount = expectedAmount - nominal;
            } else {
                i++;
            }

            if (copyOfDenominations.containsKey(nominal) && copyOfDenominations.get(nominal) == 0) {
                copyOfDenominations.remove(nominal);
            }

        }
        if (expectedAmount > 0) {
            throw new NotEnoughMoneyException();
        }
        denominations.clear();
        denominations.putAll(copyOfDenominations);
        return withdrawMap;
    }
}








