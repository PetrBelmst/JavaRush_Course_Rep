package com.company;

import com.company.exception.PathIsNotFoundException;
import com.company.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        if (!Files.exists(zipFile.getParent())) {
            Files.createDirectory(zipFile.getParent());
        }
        try (ZipOutputStream zOS = new ZipOutputStream(Files.newOutputStream(zipFile)))
        {
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zOS, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path element : fileNames) {
                    addNewZipEntry(zOS, source, element);
                }
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName)
            throws Exception {
        try (InputStream iS = Files.newInputStream(filePath.resolve(fileName)))
        {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(iS, zipOutputStream);
            zipOutputStream.closeEntry();
        } catch (Exception e) {}
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        while (in.available() > 0) {
            out.write(in.read());
        }
    }

    public List<FileProperties> getFilesList() throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        List<FileProperties> filePropertiesList = new ArrayList<>();
        try (ZipInputStream zIS = new ZipInputStream(Files.newInputStream(zipFile));
             ByteArrayOutputStream bAOS = new ByteArrayOutputStream())
        {
            ZipEntry zipEntry;
            while ((zipEntry = zIS.getNextEntry()) != null) {
                copyData(zIS, bAOS);
                filePropertiesList.add(new FileProperties(zipEntry.getName(), zipEntry.getSize(),
                        zipEntry.getCompressedSize(), zipEntry.getMethod()));
            }
            zIS.closeEntry();
        }
        return filePropertiesList;
    }

    public void extractAll(Path outputFolder) throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        if (!Files.exists(outputFolder)) {
            Files.createDirectories(outputFolder);
        }
        try (ZipInputStream zIS = new ZipInputStream(Files.newInputStream(zipFile)))
        {
            ZipEntry zipEntry = zIS.getNextEntry();
            while (zipEntry != null) {
                Path fileZipEntryPath = outputFolder.resolve(zipEntry.getName());
                Path parent = fileZipEntryPath.getParent();
                if (Files.notExists(parent)) {
                    Files.createDirectories(parent);
                }
                try (OutputStream oS = Files.newOutputStream(fileZipEntryPath)) {
                    copyData(zIS, oS);
                }
                zipEntry = zIS.getNextEntry();
            }
        }
    }

    public void removeFiles(List<Path> pathList) throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        Path tempZipFile = Files.createTempFile(null, null);

        try (ZipOutputStream zOS = new ZipOutputStream(Files.newOutputStream(tempZipFile));
             ZipInputStream zIS = new ZipInputStream(Files.newInputStream(zipFile)))
        {
            ZipEntry zipEntry = zIS.getNextEntry();
            while (zipEntry != null) {
                if (pathList.contains(Paths.get(zipEntry.getName()))) {
                    ConsoleHelper.writeMessage("File " + zipEntry.getName() + " was removed");
                } else {
                    zOS.putNextEntry(new ZipEntry(zipEntry.getName()));
                    copyData(zIS, zOS);
                    zIS.closeEntry();
                    zOS.closeEntry();
                }
                zipEntry = zIS.getNextEntry();
            }
            Files.move(tempZipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public void removeFile(Path path) throws Exception {
        removeFiles(Collections.singletonList(path));
    }

    public void addFiles(List<Path> absolutePathList) throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        Path tempzipFile = Files.createTempFile(null, null);
        List<Path> filesPath = new ArrayList<>();

        try (ZipOutputStream zOS = new ZipOutputStream(Files.newOutputStream(tempzipFile));
             ZipInputStream zIS = new ZipInputStream(Files.newInputStream(zipFile)))
        {
            ZipEntry zipEntry = zIS.getNextEntry();
            while (zipEntry != null) {
                zOS.putNextEntry(new ZipEntry(zipEntry.getName()));
                copyData(zIS, zOS);
                filesPath.add(Paths.get(zipEntry.getName()));
                zipEntry = zIS.getNextEntry();
            }
            for (Path element : absolutePathList) {
                if (!Files.isRegularFile(element) && !Files.exists(element)) {
                    throw new PathIsNotFoundException();
                }
                if (filesPath.contains(element.getFileName())) {
                    ConsoleHelper.writeMessage("File " + element.toString() + " already exist");
                } else {
                    addNewZipEntry(zOS, element.getParent(), element.getFileName());
                    ConsoleHelper.writeMessage("File " + element.toString() + " was added");
                }
            }
        }
        Files.move(tempzipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }
    public void addFile(Path absolutePath) throws Exception {
        addFiles(Collections.singletonList(absolutePath));
    }
}