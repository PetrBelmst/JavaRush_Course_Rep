package com.company;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;


public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain()
                .getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName()
                .replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> resultSet = new HashSet<>();

        File[] listOfFiles = new File(pathToAnimals).listFiles();
        for (File elementF : listOfFiles) {
            if (elementF.isFile() && elementF.getName().endsWith(".class")) {

                String packName = Solution.class.getPackage().getName() + ".data";
                Class clazz = new ClassByPath().getClass(elementF.toPath(), packName);

                int count = 0;

                Class[] interfaces = clazz.getInterfaces();
                for (Class elementC : interfaces)
                    if (elementC.getSimpleName().toString().equals("Animal")) {
                        count++;
                        break;
                    }


                Constructor[] constructors = clazz.getConstructors();
                for (Constructor constructor : constructors)
                    if (constructor.getParameterCount() == 0) {
                        count++;
                    }


                if (count == 2)
                    try {
                        Animal animal = (Animal) clazz.newInstance();
                        resultSet.add(animal);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
            }
        }

        return resultSet;
    }

    public static class ClassByPath extends ClassLoader {
        public Class<?> getClass (Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString()
                        .replace(".class", "");
                byte[] fileBytes = Files.readAllBytes(path);
                return defineClass(className, fileBytes, 0, fileBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
