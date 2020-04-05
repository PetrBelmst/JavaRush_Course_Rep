package com.company;

import com.company.command.CommandExecutor;
import com.company.exception.InterruptOperationException;

import java.util.Locale;

import static com.company.command.CommandExecutor.execute;


public class CashMachine {

    public static final String RESOURCE_PATH = "com.company.resources.";

    public static void main(String[] args) throws InterruptOperationException {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Operation askOperation;
            CommandExecutor.execute(Operation.LOGIN);
            do {
                askOperation = ConsoleHelper.askOperation();
                execute(askOperation);
            } while (!Operation.EXIT.equals(askOperation));
        } catch (InterruptOperationException e) {
            CommandExecutor.execute(Operation.LOGIN);
        }
    }
}
