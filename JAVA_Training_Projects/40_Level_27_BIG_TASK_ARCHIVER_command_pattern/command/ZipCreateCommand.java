package com.company.command;

import com.company.ConsoleHelper;
import com.company.ZipFileManager;
import com.company.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Please input absolute path of file or directory to be archived");
            String pathOfTheElementToBeArchived = ConsoleHelper.readString();
            Path elemenntToBeArchivedPath = Paths.get(pathOfTheElementToBeArchived);
            zipFileManager.createZip(elemenntToBeArchivedPath);
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException p) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}