package com.example.assignment.backend.services;

import com.example.assignment.backend.exceptions.InvalidObjectException;
import com.example.assignment.backend.models.dto.CreateStaff;
import com.example.assignment.backend.models.staff.Lecturer;
import com.example.assignment.backend.models.staff.Manageable;
import com.example.assignment.backend.models.staff.Staff;
import com.example.assignment.backend.repository.StaffStorageRepository;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturerServiceImpl implements StaffManager<Manageable> {
    private final StaffStorageRepository repository;

    private static LecturerServiceImpl instance;

    private LecturerServiceImpl() throws ConfigurationException {
        this.repository = StaffStorageRepository.getInstance();
    }

    public static LecturerServiceImpl getInstance() throws ConfigurationException {
        // local variable increases performance by 25 percent
        // Joshua Bloch "Effective Java, Second Edition", p. 283-284

        var result = instance;

        if (result == null) {

            synchronized (LecturerServiceImpl.class) {
                result = instance;
                if (result == null) {
                    result = new LecturerServiceImpl();
                    instance = result;
                }
            }
        }
        return result;
    }


    @Override
    public void create(Manageable obj) throws InvalidObjectException, IOException {
        if (!(obj instanceof CreateStaff)) {
            throw new InvalidObjectException("Invalid object type. Expected CreateStaff.");
        }
        CreateStaff request = (CreateStaff) obj;
        Lecturer newLecturer = new Lecturer();
        newLecturer.setId(request.getId());

        // Validate and set first name
        if (request.getFirstName() != null && !request.getFirstName().isBlank()) {
            newLecturer.setFirstName(request.getFirstName());
        } else {
            throw new InvalidObjectException("First name cannot be null or empty.");
        }

        // Validate and set last name
        if (request.getLastName() != null && !request.getLastName().isBlank()) {
            newLecturer.setLastName(request.getLastName());
        } else {
            throw new InvalidObjectException("Last name cannot be null or empty.");
        }

        // Validate and set email
        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            newLecturer.setEmail(request.getEmail());
        } else {
            throw new InvalidObjectException("Email cannot be null or empty.");
        }

        // Validate and set manager ID
        if (request.getManagerId() != null && !request.getManagerId().isBlank()) {
            newLecturer.setManager(request.getManagerId());

        } else {
            throw new InvalidObjectException("Manager ID cannot be null or empty.");
        }

        // Set contract type and subject area
        if (request.getContractType() != null) {
            newLecturer.setContractType(request.getContractType());
        }

        if (request.getSubjectArea() != null) {
            newLecturer.setSubjectArea(request.getSubjectArea());
        }

        // Save or process newLecturer as needed (e.g., save to a database)
        repository.save(newLecturer.getId(), newLecturer);
    }




    @Override
    public void update(String id,Manageable data) throws IOException, ClassNotFoundException {
        Lecturer lecturer = repository.get(id);
        if (lecturer == null) throw new FileNotFoundException("Lecturer with id:%s doesn't exist".formatted(id));

        //Update Lecturer details


        repository.save(lecturer.getId(), lecturer);
    }

    @Override
    public void delete(String id) throws IOException {
        repository.delete(id);
    }

    @Override
    public Manageable get(String id) throws IOException, ClassNotFoundException {
        return repository.get(id);
    }

    @Override
    public List<Manageable> findAll() throws IOException, ClassNotFoundException {
        List<Manageable> result = new ArrayList<>();
        for(Staff s: repository.findAll()){
            Lecturer l = (Lecturer) s;
            result.add(l);
        }

        return result;
    }
}
