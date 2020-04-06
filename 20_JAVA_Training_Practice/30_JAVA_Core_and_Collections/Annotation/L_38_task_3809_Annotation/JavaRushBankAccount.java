package com.company;

public class JavaRushBankAccount {
    private String ownerName;

    @LongPositive
    private long amount;

    public JavaRushBankAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
