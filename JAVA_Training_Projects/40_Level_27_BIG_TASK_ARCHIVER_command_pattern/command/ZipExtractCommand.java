package com.company.command;

import com.company.ConsoleHelper;
import com.company.ZipFileManager;
import com.company.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Извлечение архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Please input absolute path for extracting of the archive");
            String pathOfTheArchive = ConsoleHelper.readString();
            Path archivePath = Paths.get(pathOfTheArchive);
            zipFileManager.extractAll(archivePath);
            ConsoleHelper.writeMessage("Архив извлечен.");
        } catch (PathIsNotFoundException p) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}