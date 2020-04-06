package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
/*
Отправка GET-запроса через сокет
Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.
Адрес сервера и параметры для GET-запроса получи из параметра url.
Порт используй дефолтный для http (80).
Классы HttpURLConnection, HttpClient и т.д. не использовать.
Не оставляй закомементированный код.

Требования:
•	Метод getSite должен создавать объект класса Socket с правильными параметрами (String host, int port).
•	Метод getSite должен записать в OutputStream правильный запрос.
•	Метод getSite должен выводить на экран InputStream сокета.
•	Метод getSite не должен использовать HttpURLConnection или HttpClient.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket socket = new Socket(url.getHost(), url.getDefaultPort());

            //получаем OutputStream, чтобы писать в него данные запроса
            OutputStream oS = socket.getOutputStream();

            String request = "GET " + url.getFile() + " HTTP/1.1\r\n";
            request += "Host: " + url.getHost() + "\r\n\r\n";

            oS.write(request.getBytes());
            oS.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;

            while ((responseLine = reader.readLine()) != null) {
                System.out.println(responseLine);
            }
            reader.close();
            oS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
