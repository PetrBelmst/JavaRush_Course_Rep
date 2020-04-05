package com.company.command;

import com.company.Operation;
import com.company.exception.InterruptOperationException;
import com.company.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private static final Map<Operation, Command> allKnownCommandsMap;
    static
    {
        allKnownCommandsMap = new HashMap<>();
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
        allKnownCommandsMap.put(Operation.LOGIN, new LoginCommand());
    }

    private CommandExecutor() {
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        allKnownCommandsMap.get(operation).execute();
    }
}
