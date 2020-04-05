package com.company.command;

import com.company.ConsoleHelper;
import com.company.ZipFileManager;
import com.company.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Add file to archive");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Please input absolute path of the file to be added");
            String pathOfTheAddedFile = ConsoleHelper.readString();
            Path addedFilePath = Paths.get(pathOfTheAddedFile);
            zipFileManager.addFile(addedFilePath);
            ConsoleHelper.writeMessage("File was added");
        } catch (PathIsNotFoundException p) {
            ConsoleHelper.writeMessage("File not found");
        }
    }
}