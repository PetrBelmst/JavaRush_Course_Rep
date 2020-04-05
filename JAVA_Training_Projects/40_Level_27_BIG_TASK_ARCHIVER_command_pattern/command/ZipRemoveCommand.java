package com.company.command;

import com.company.ConsoleHelper;
import com.company.ZipFileManager;


import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
            ConsoleHelper.writeMessage("Remove from archive");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Please input absolute path of the file to be removed");
            String pathOfTheFileToBeRemoved = ConsoleHelper.readString();
            Path archivePath = Paths.get(pathOfTheFileToBeRemoved);
            zipFileManager.removeFile(archivePath);
            ConsoleHelper.writeMessage("File has been removed");
    }
}