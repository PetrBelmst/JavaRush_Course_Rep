package com.company;
import java.io.File;
import java.io.IOException;
import java.util.*;

/*
Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов
включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.

Требования:
•	Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
•	Метод getFileTree должен возвращать список строк.
•	Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
•	Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
 */
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> absoluteFileNames = new ArrayList<>();
        Queue<File> fileQueue = new LinkedList<>();
        fileQueue.add(new File(root));

        while (!fileQueue.isEmpty()) {
            File temp = fileQueue.poll();
            if (temp.isDirectory()) {
                for (File element : temp.listFiles()) {
                    if (element.isDirectory()) {
                        fileQueue.add(element);
                    } else {
                        absoluteFileNames.add(element.getAbsolutePath());
                    }
                }
            }
        }

        return absoluteFileNames;

    }

    public static void main(String[] args) {

    }
}
