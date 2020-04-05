package com.company;

public enum Operation {
    LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        switch (i) {
            case 1: return INFO;
            case 2: return DEPOSIT;
            case 3: return WITHDRAW;
            case 4: return EXIT;
            case 0:
            default: throw new IllegalArgumentException();
        }
    }
}
