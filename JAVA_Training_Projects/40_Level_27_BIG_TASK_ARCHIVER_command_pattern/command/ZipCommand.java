package com.company.command;

import com.company.ConsoleHelper;
import com.company.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Please input absolute archive path");
        String absoluteArchivePath = ConsoleHelper.readString();
        Path pathToArchive = Paths.get(absoluteArchivePath);
        return new ZipFileManager(pathToArchive);
    }
}