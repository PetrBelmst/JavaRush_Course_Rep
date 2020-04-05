package com.company.command;

import com.company.CashMachine;
import com.company.ConsoleHelper;
import com.company.CurrencyManipulator;
import com.company.CurrencyManipulatorFactory;
import com.company.exception.InterruptOperationException;

import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> allManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (allManipulators.isEmpty()) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
        for (CurrencyManipulator element : allManipulators) {
            if (element.hasMoney()) {
                ConsoleHelper.writeMessage(element.getCurrencyCode() + " - " + element.getTotalAmount());
            } else {
                ConsoleHelper.writeMessage(res.getString("no.money"));
            }
        }
    }
}
