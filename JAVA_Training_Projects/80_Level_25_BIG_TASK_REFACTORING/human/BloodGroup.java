package com.company.human;

public class BloodGroup {

    private final int code;

    private BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BloodGroup first() {
        BloodGroup firstBG = new BloodGroup(1);
        return firstBG;
    }

    public static BloodGroup second() {
        BloodGroup secondBG = new BloodGroup(2);
        return secondBG;
    }

    public static BloodGroup third() {
        BloodGroup thirdBG = new BloodGroup(3);
        return thirdBG;
    }

    public static BloodGroup fourth() {
        BloodGroup fourthBG = new BloodGroup(4);
        return fourthBG;
    }
}






/*
Рефакторинг (9)
public class BloodGroup {

    private final int code;

    private BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
   public static BloodGroup first() {
        BloodGroup firstBG = new BloodGroup(1);
        return firstBG;
    }

    public static BloodGroup second() {
        BloodGroup secondBG = new BloodGroup(2);
        return secondBG;
    }

    public static BloodGroup third() {
        BloodGroup thirdBG = new BloodGroup(3);
        return thirdBG;
    }

    public static BloodGroup fourth() {
        BloodGroup fourthBG = new BloodGroup(4);
        return fourthBG;
    }
}
 */