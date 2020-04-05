package com.company.client;

import com.company.*;

import java.io.IOException;
import java.net.Socket;


public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Input server address, IP or LocalHost");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Input port number");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Input User Name");
        return ConsoleHelper.readString();
    }
    // в данной реализации клиента всегда должен возвращать true, метод должен быть переопределен
    // для другого клиента, унаследованный от данного, который не должен отправлять введенный
    // в консоль текст
    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Submission of the message was failed");
            clientConnected = false;
        }
    }

    public void run() {
        Thread socketTread = getSocketThread();
        socketTread.setDaemon(true);
        socketTread.start();
        try {
            synchronized (this) {
                wait();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("An error occurred" + e.getMessage());
            return;
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено.\n" +
                    "Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            String userMessage = ConsoleHelper.readString();
            if (userMessage.equals("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(userMessage);
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();

        Client client1 = new Client();
        client.run();
    }

    public class SocketThread extends Thread {

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message messageFromServer;
            while (true) {
                messageFromServer = connection.receive();
                if (MessageType.NAME_REQUEST.equals(messageFromServer.getType())) {
                    String userName = getUserName();
                    Message userNameMessage = new Message(MessageType.USER_NAME, userName);
                    connection.send(userNameMessage);
                } else if (MessageType.NAME_ACCEPTED.equals(messageFromServer.getType())) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        //Цикл будет завершен автоматически если произойдет ошибка (будет брошено исключение)
        // или поток, в котором работает цикл, будет прерван
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message messageFromServer;
            while (true) {
                messageFromServer = connection.receive();
                if (MessageType.TEXT.equals(messageFromServer.getType())) {
                    processIncomingMessage(messageFromServer.getData());
                } else if (MessageType.USER_ADDED.equals(messageFromServer.getType())) {
                    informAboutAddingNewUser(messageFromServer.getData());
                } else if (MessageType.USER_REMOVED.equals(messageFromServer.getType())) {
                    informAboutDeletingNewUser(messageFromServer.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();

            try (Socket clientSocket = new Socket(serverAddress, serverPort))
            {
                connection = new Connection(clientSocket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("New user join the chat" + userName);
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("User has left the chat" + userName);
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }
}

