package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
Требования:
•	Класс Solution должен содержать public static поле allLines типа List<String>.
•	Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
•	Класс Solution должен содержать public void метод joinData() который может бросать исключение
CorruptedDataException.
•	Программа должна считывать c консоли имена двух файлов.
•	Программа должна считывать построчно данные из первого файла в список allLines.
•	Программа должна считывать построчно данные из второго файла в список forRemoveLines.
•	Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines
содержаться все строки из списка forRemoveLines.
•	Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines
не содержаться все строки из списка forRemoveLines.
•	Метод joinData должен вызываться в main.
*/
public class Main {

    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException {
        BufferedReader rdrFileName = new BufferedReader(new InputStreamReader(System.in));
        String file1 = "";
        String file2 = "";
        try {
            file1 = rdrFileName.readLine();
            file2 = rdrFileName.readLine();
            rdrFileName.close();
        } catch (Exception e) {
        }

        try {
            BufferedReader rdrFileContent1 = new BufferedReader(new FileReader(file1));
            String line1;
            while ((line1 = rdrFileContent1.readLine()) != null) {
                allLines.add(line1);
            }
            rdrFileContent1.close();

            BufferedReader rdrFileContent2 = new BufferedReader(new FileReader(file2));
            String line2;
            while ((line2 = rdrFileContent2.readLine()) != null) {
                forRemoveLines.add(line2);
            }
            rdrFileContent2.close();
        } catch (Exception e) {
        }

        Main m = new Main();
        m.joinData();
    }

    public void joinData() throws CorruptedDataException {
        for (String remove : forRemoveLines) {
            if (!allLines.remove(remove)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }

    }
}
