package com.example.assignment.backend.services;

import com.example.assignment.backend.models.SystemConfig;

import java.io.*;

class StorageManagerImpl implements StorageManager {
    private SystemConfig config;


    public void saveFile(Serializable object, String filename) throws IOException {
//        String filePath = cofig.

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(object);
    }
}
