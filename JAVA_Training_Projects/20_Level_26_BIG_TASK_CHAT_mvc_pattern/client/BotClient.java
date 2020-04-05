package com.company.client;


import com.company.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BotClient extends Client{

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + ((int) (Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(": ")) {
                String [] splittedMessage = message.split(": ");
                String userName = splittedMessage[0];
                String userRequest = splittedMessage[1];
                SimpleDateFormat userRequestFormat = null;
                switch (userRequest) {
                    case "дата":
                        userRequestFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        userRequestFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        userRequestFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        userRequestFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        userRequestFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        userRequestFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        userRequestFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        userRequestFormat = new SimpleDateFormat("s");
                        break;
                }
                if (userRequestFormat != null) {
                    sendTextMessage(String.format("Информация для %s: %s",
                            userName, userRequestFormat.format(Calendar.getInstance().getTime())));
                }
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, " +
                    "время, час, минуты, секунды.");

            super.clientMainLoop();

        }
    }
}
