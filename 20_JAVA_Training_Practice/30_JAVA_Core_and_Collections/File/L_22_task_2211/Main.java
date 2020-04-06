package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/*
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое
первого файла в кодировке UTF-8.
Требования:
•	Программа НЕ должна считывать данные с клавиатуры.
•	Программа НЕ должна выводить данные на экран.
•	Программа должна записывать данные в файл.
•	Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Main {

    public static void main(String[] args) throws IOException {
        File fileWin1251 = new File(args[0]);
        File fileUTF8 = new File(args[1]);

        FileInputStream fIS = new FileInputStream(fileWin1251);
        FileOutputStream fOS = new FileOutputStream(fileUTF8);

        byte[] forfIS = new byte[fIS.available()];
        fIS.read(forfIS);
        fIS.close();

        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        String arrToStrWin1251 = new String(forfIS, win1251);
        byte[] utf8Format = arrToStrWin1251.getBytes(utf8);
        fOS.write(utf8Format);
        fOS.flush();
        fOS.close();
    }
}
