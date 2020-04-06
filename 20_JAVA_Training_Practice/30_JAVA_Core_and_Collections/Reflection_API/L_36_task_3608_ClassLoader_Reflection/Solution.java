package com.company;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File[] filesFromPackage = new File(packageName).listFiles();
        ClassLoaderFromPath loader = new ClassLoaderFromPath();

        for (File element : filesFromPackage) {
            Class<?> clazz = loader.load(element.toPath());
            if (clazz != null)
                hiddenClasses.add(clazz);
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class<?> clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] constructorsList = clazz.getDeclaredConstructors();
                    for (Constructor element : constructorsList) {
                        if (element.getParameterTypes().length == 0) {
                            element.setAccessible(true);
                            return (HiddenClass) element.newInstance(null);
                        }
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }

    public static class ClassLoaderFromPath extends ClassLoader {
        public Class<?> load(Path path) {
            try {
                if (path.getFileName().toString().lastIndexOf(".class") == -1)
                    return null;

                byte[] bytesFromPath = Files.readAllBytes(path);
                return defineClass(null, bytesFromPath, 0, bytesFromPath.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}


