package com.example.assignment.backend.repository;

import com.example.assignment.backend.models.staff.Lecturer;
import com.example.assignment.backend.models.staff.Staff;
import com.example.assignment.backend.services.ConfigurationManager;
import com.example.assignment.backend.services.FileManager;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that handles the Lecturer class object storage.
 */
public class StaffStorageRepository implements Repository<String, Staff> {
    private String dir;
    private final static String FILE_EXTENSION = ".dat";

    private static StaffStorageRepository instance;


    private StaffStorageRepository() throws ConfigurationException {
        dir = ConfigurationManager.getInstance().getConfiguration().getStaffStorageLocation();
    }

    public static StaffStorageRepository getInstance() throws ConfigurationException {
        // local variable increases performance by 25 percent
        // Joshua Bloch "Effective Java, Second Edition", p. 283-284

        var result = instance;
        // Check if singleton instance is initialized.
        // If it is initialized then we can return the instance.
        if (result == null) {
            // It is not initialized, but we cannot be sure because some other thread might have
            // initialized it in the meanwhile.
            // So to make sure we need to lock on an object to get mutual exclusion.
            synchronized (StaffStorageRepository.class) {
                // Again assign the instance to local variable to check if it was initialized by some
                // other thread while current thread was blocked to enter the locked zone.
                // If it was initialized then we can return the previously created instance
                // just like the previous null check.
                result = instance;
                if (result == null) {
                    // The instance is still not initialized, so we can safely
                    // (no other thread can enter this zone)
                    // create an instance and make it our singleton instance.

                    result = new StaffStorageRepository();
                    instance = result;
                }
            }
        }
        return result;
    }


    public void save(String filename, Staff lecturer ) throws IOException {
        if(filename == null || filename.isBlank()) throw new InvalidObjectException("filename cannot be null or blank");
        FileManager.save(dir +"/%s%s".formatted(filename,FILE_EXTENSION),lecturer);
    }

    @Override
    public void delete(String filename) throws IOException {
        FileManager.delete(dir +"/%s.%s".formatted(filename, FILE_EXTENSION));
    }

    @Override
    public Lecturer get(String id) throws IOException, ClassNotFoundException {
        return (Lecturer) FileManager.get(dir + "/%s%s".formatted(id, FILE_EXTENSION));
    }

    @Override
    public List<Staff> findAll() throws IOException, ClassNotFoundException {
        List<Serializable> all = FileManager.getAll(dir, FILE_EXTENSION);
        List<Staff> result = new ArrayList<>();
        for(Serializable obj : all){
            String path = ((File)obj).getPath();
            result.add((Lecturer)FileManager.get(path));
        }
        return result;
    }

    @Override
    public void deleteAll() throws IOException, ClassNotFoundException {
        List<Staff> list = findAll();
        for(Staff s : list){
            delete(s.getId());
        }
    }
}
