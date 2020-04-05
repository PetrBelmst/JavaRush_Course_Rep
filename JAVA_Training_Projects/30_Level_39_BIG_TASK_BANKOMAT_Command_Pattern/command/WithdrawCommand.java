package com.company.command;

import com.company.CashMachine;
import com.company.ConsoleHelper;
import com.company.CurrencyManipulator;
import com.company.CurrencyManipulatorFactory;
import com.company.exception.InterruptOperationException;
import com.company.exception.NotEnoughMoneyException;


import java.util.*;

class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        Map<Integer, Integer> temp = new TreeMap<>(Comparator.reverseOrder());
        String currCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currMan = CurrencyManipulatorFactory
                .getManipulatorByCurrencyCode(currCode);

        while (true) {

            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            int inputAmount;

            try {
                inputAmount = Integer.parseInt(ConsoleHelper.readString());
                if (inputAmount <= 0) {
                    throw new NumberFormatException();
                }
                if (!currMan.isAmountAvailable(inputAmount)) {
                    throw new NotEnoughMoneyException();
                }

                temp.putAll(currMan.withdrawAmount(inputAmount));

                for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                    ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
                }
                ConsoleHelper.writeMessage(String.format
                        (res.getString("success.format"), inputAmount, currCode));
                return;

            } catch (NumberFormatException e) {
                System.out.println(res.getString("specify.not.empty.amount"));
                continue;
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
        }
    }
}
