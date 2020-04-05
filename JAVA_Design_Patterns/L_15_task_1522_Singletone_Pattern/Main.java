package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
            readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputData = rdr.readLine();
            rdr.close();
            if (inputData.equals(Planet.EARTH)) {
                thePlanet = Earth.getInstance();
            } else if (inputData.equals(Planet.MOON)) {
                thePlanet = Moon.getInstance();
            } else if (inputData.equals(Planet.SUN)) {
                thePlanet = Sun.getInstance();
            } else {
                thePlanet = null;
            }
        }
        catch (IOException e) {e.printStackTrace();}
    }
}














