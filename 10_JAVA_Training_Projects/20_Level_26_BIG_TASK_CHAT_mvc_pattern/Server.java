package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Message was not delivered: " + e.getMessage());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message reply = connection.receive();

                if (reply.getType() == MessageType.USER_NAME && !reply.getData().isEmpty()
                        && !connectionMap.containsKey(reply.getData())) {
                    connectionMap.put(reply.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return reply.getData();
                }
            }
        }

        // notifyUsers -> notifyNewUserAboutListOfUserInTheChat
        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!userName.equals(entry.getKey())) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException,
                ClassNotFoundException {
            while (true) {
                Message receivedMessage = connection.receive();

                if (receivedMessage.getType() != MessageType.TEXT) {
                    ConsoleHelper.writeMessage("Error, received message not a TEXT");
                } else {
                    String messageDataToBeSubmitted = userName + ": " + receivedMessage.getData();
                    Message messageToBeSubmitted = new Message(MessageType.TEXT, messageDataToBeSubmitted);
                    sendBroadcastMessage(messageToBeSubmitted);
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("New connection was created with the following address: "
                    + socket.getRemoteSocketAddress());
            String newUserName = null;
            try (Connection newClientConnection = new Connection(socket)) {
                newUserName = serverHandshake(newClientConnection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,
                        "New user was added to the chat with the following name: " + newUserName));
                notifyUsers(newClientConnection, newUserName);
                serverMainLoop(newClientConnection, newUserName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error appeared during data exchange with the following address"
                        + socket.getRemoteSocketAddress() + e.getMessage() + "\n" + e.getStackTrace());
            } finally {
                if (newUserName != null) {
                    connectionMap.remove(newUserName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUserName));
                }
            }
            ConsoleHelper.writeMessage("Connection with was closed");
        }
    }

    public static void main(String[] args) {
        // write your code here
        ConsoleHelper.writeMessage("Provide port number");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server has been started");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Handler handler = new Handler(clientSocket);
                handler.start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Something goes wrong, serverSocket was closed: " + e.getMessage());
        }
    }
}
