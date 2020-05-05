package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//вспомогательные методы для заполнения тестового файла
public class IpFileGenerator {

    public static String generator() {
        short s = 255;
        Random random = new Random();
        String someIP = random.nextInt(s) + "."
                + random.nextInt(s) + "."
                + random.nextInt(s) + "."
                + random.nextInt(s);
        return someIP;
    }

    public static void writeFile(File file, Long ipQTY) {
        try (FileWriter writer = new FileWriter(file)) {
            while (ipQTY > 0) {
                ipQTY--;
                writer.write(generator() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
