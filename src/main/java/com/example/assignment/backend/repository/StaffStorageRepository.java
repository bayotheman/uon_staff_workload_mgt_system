package com.example.assignment.backend.repository;

import com.example.assignment.backend.models.staff.Lecturer;
import com.example.assignment.backend.models.staff.Staff;
import com.example.assignment.backend.services.ConfigurationManager;
import com.example.assignment.backend.services.FileManager;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that handles the nutty-gritty of Lecturer class object storage
 */
public class StaffStorageRepository implements Repository<String, Staff> {
    private String dir;


    public StaffStorageRepository(ConfigurationManager configurationManager) throws ConfigurationException {
        dir = configurationManager.readConfiguration().getStaffStorageLocation();
    }

    public void save(String filename, Staff lecturer ) throws IOException {
        FileManager.save(dir +"/%s.dat".formatted(filename),lecturer);
    }

    @Override
    public void delete(String filename) throws IOException {
        FileManager.delete(dir +"/%s.dat".formatted(filename));
    }

    @Override
    public Lecturer get(String id) throws IOException, ClassNotFoundException {
        return (Lecturer) FileManager.get(dir + "/" + id +".dat");
    }

    @Override
    public List<Staff> findAll() throws IOException, ClassNotFoundException {
        List<Serializable> all = FileManager.getAll(dir);
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
