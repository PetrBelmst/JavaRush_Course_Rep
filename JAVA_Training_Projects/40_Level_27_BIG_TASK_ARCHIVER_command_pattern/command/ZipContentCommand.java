package com.company.command;

import com.company.ConsoleHelper;
import com.company.FileProperties;
import com.company.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> filePropertiesList = zipFileManager.getFilesList();
        filePropertiesList.stream().forEach(x -> ConsoleHelper.writeMessage(filePropertiesList.toString()));
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}