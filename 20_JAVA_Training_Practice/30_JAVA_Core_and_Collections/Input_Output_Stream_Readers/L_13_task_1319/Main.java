package com.company;

import java.io.*;

/*
Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
Требования:
•	Программа должна считывать c консоли имя файла.
•	Создай и используй объект типа BufferedWriter.
•	Программа не должна ничего читать из файловой системы.
•	Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
•	Программа должна записать абсолютно все введенные строки (включая "exit") в файл,
каждую строчку с новой строки.
•	Метод main должен закрывать объект типа BufferedWriter после использования.
•	Метод main не должен выводить данные на экран.
*/

public class Main {

    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rdr.readLine();

        File file = new File(fileName);

        BufferedWriter wrt = new BufferedWriter(new FileWriter(file));

        String inputline;
        while (true) {
            inputline = rdr.readLine();
            wrt.write(inputline);
            wrt.newLine();
            if (inputline.equals("exit")) {
                break;
            }
        }
        rdr.close();
        wrt.close();
    }
}
