package com.company.command;

import com.company.CashMachine;
import com.company.ConsoleHelper;
import com.company.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards", Locale.ENGLISH);
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String inputCard;
        String inputPin;

        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            inputCard = ConsoleHelper.readString();
            inputPin = ConsoleHelper.readString();

            if (inputCard.length() != 12 || inputPin.length() != 4) {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), inputCard));
                continue;
            }
            if (validCreditCards.containsKey(inputCard) && validCreditCards.getString(inputCard).equals(inputPin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), inputCard));
                break;
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), inputCard));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}
