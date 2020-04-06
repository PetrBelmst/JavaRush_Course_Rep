package com.company;

/*
Проход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего
файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(),
и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого
тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).

Требования:
•	Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
•	Нужно создать поток для записи в переименованный файл.
•	Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл
allFilesContent.txt в отсортированном по имени файла порядке.
•	Поток для записи в файл нужно закрыть.
•	Не используй статические переменные.
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public ArrayList<File> listOfFiles = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Solution solution = new Solution();

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        solution.addToListOfFiles(path.getPath());
        solution.listOfFiles.sort(Comparator.comparing(File::getName));

        try (FileOutputStream fOS = new FileOutputStream(allFilesContent)) {
            for (File file : solution.listOfFiles) {
                FileInputStream fIS = new FileInputStream(file);
                while (fIS.available() > 0) {
                    fOS.write(fIS.read());
                }
                fOS.write(System.lineSeparator().getBytes());
                fOS.flush();
                fIS.close();
            }
        }
    }
    public void addToListOfFiles(String path) {
        File temp = new File(path);
        File[] files = temp.listFiles();
        for (File element : files) {
            if (element.isDirectory()) {
                addToListOfFiles(element.getAbsolutePath());
                continue;
            }
            if (element.length() > 50)
                FileUtils.deleteFile(element);
            else
                listOfFiles.add(element);
        }
    }
}