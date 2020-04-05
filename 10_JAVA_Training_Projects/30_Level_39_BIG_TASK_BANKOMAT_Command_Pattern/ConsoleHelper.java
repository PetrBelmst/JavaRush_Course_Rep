package com.company;

import com.company.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage()
            .getName() + ".resources.common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String text = null;
        try {
            text = bis.readLine();
            if (text.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) {}
        return text;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String inputCode = "";
        while (inputCode.length() != 3) {
            writeMessage(res.getString("choose.currency.code"));
            inputCode = readString();
            if (inputCode.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            }
        }
        return inputCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] inputNominalAndQTY;
        int nominal;
        int quantity;
        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            try {
                inputNominalAndQTY = readString().split(" ");
                if (inputNominalAndQTY.length != 2) {
                    throw new NumberFormatException();
                }
                nominal = Integer.parseInt(inputNominalAndQTY[0]);
                quantity = Integer.parseInt(inputNominalAndQTY[1]);

                if (nominal <= 0 || quantity <= 0) {
                    throw new NumberFormatException();
                }

            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            return inputNominalAndQTY;
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - " + res.getString("operation.INFO"));
            writeMessage("2 - " + res.getString("operation.DEPOSIT"));
            writeMessage("3 - " + res.getString("operation.WITHDRAW"));
            writeMessage("4 - " + res.getString("operation.EXIT"));
            try {
                int operationNumber = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(operationNumber);
            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        }
    }

    public static void printExitMessage()
    {
        writeMessage(res.getString("the.end"));
    }
}
