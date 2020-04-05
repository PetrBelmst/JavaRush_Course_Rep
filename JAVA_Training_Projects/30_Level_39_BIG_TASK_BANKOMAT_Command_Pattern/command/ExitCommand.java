package com.company.command;

import com.company.CashMachine;
import com.company.ConsoleHelper;
import com.company.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String reply = ConsoleHelper.readString();
        if (reply.equalsIgnoreCase("y")) {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
