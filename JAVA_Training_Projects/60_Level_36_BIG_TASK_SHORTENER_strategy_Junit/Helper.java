package com.company;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(36);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
