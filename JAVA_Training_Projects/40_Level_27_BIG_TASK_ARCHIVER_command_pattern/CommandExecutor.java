package com.company;

import com.company.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

    static {
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.ADD, new ZipAddCommand());
        allKnownCommandsMap.put(Operation.CONTENT, new ZipContentCommand());
        allKnownCommandsMap.put(Operation.CREATE, new ZipCreateCommand());
        allKnownCommandsMap.put(Operation.EXTRACT, new ZipExtractCommand());
        allKnownCommandsMap.put(Operation.REMOVE, new ZipRemoveCommand());
    }

    private CommandExecutor() {}

    public static void execute(Operation operation) throws Exception {
        allKnownCommandsMap.get(operation).execute();
    }
}