package com.company.strategy;

import com.company.ExceptionHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {

    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {}
        return 0;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entry);
        } catch (IOException e) {}
    }

    public Entry getEntry() {
        Entry returnedEntry = null;

        if (getFileSize() <= 0) {
            return returnedEntry;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            returnedEntry = (Entry) objectInputStream.readObject();
        } catch (IOException e) {}
        catch (ClassNotFoundException e) {}
        return returnedEntry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {}
    }
}
