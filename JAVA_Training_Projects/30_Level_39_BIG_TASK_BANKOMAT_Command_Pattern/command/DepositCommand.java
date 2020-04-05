package com.company.command;

import com.company.CashMachine;
import com.company.ConsoleHelper;
import com.company.CurrencyManipulator;
import com.company.CurrencyManipulatorFactory;
import com.company.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));
        String currCode = ConsoleHelper.askCurrencyCode();
        int nominal = 0;
        int quantity = 0;
        CurrencyManipulator manipulator = CurrencyManipulatorFactory
                .getManipulatorByCurrencyCode(currCode);

        try {
            String[] cashInfo = ConsoleHelper.getValidTwoDigits(currCode);
            nominal = Integer.parseInt(cashInfo[0]);
            quantity = Integer.parseInt(cashInfo[1]);
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
        manipulator.addAmount(nominal, quantity);
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),
                nominal * quantity, currCode));
    }
}
