package com.example.assignment.backend.services;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    public static final String FILE_EXTENSION = ".dat";

    private FileManager(){}

    public static void save(String filePath, Serializable object ) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(object);
    }

    public static void update(String filePath, Serializable newObject) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(newObject);
        }
    }

    public static Serializable get(String fullPath) throws IOException, ClassNotFoundException {
//        String fullPath = path + "/" + filename;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fullPath))) {
            // Deserialize and return the object
            return (Serializable) objectInputStream.readObject();
        }
    }

    public static List<Serializable> getAll(String directoryPath){
        File directory = new File(directoryPath);
        List<Serializable> datFiles = new ArrayList<>();

        // Ensure the path is a directory
        if (directory.isDirectory()) {
            // List all files in the directory
            File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

            // Add the .dat files to the list
            if (files != null) {
                datFiles.addAll(Arrays.asList(files));
            }
        }

        return datFiles;
    }

    public static void delete(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("Failed to delete the file: " + filePath);
            }
        } else {
            throw new IOException("File not found: " + filePath);
        }
    }
}
