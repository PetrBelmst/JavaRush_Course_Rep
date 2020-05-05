package com.company;

import java.io.*;
import java.util.Date;

import static com.company.ArrayCounter.uniqueIPCounter;
import static com.company.IpFileGenerator.*;
import static com.company.SetCounter.setCount;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\User\\Desktop\\test_file_2.txt");
        //writeFile(file, 70_000_000L);

        Date start = new Date();
        System.out.println(uniqueIPCounter(file) + " unique IPs number");
        Date finish = new Date();
        Long diff = finish.getTime() - start.getTime();
        System.out.println("Total time for uniqueIPCounter method took Ms: " + diff);

        Date start1 = new Date();
        System.out.println(setCount(file) + " unique IPs number");
        Date finish1 = new Date();
        Long diff1 = finish1.getTime() - start1.getTime();
        System.out.println("Total time for setCount method took Ms: " + diff1);
    }
}
