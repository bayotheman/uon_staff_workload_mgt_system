package com.example.assignment.backend.services;

import com.example.assignment.backend.exceptions.InvalidObjectCreationException;
import com.example.assignment.backend.models.dto.CreateStaff;
import com.example.assignment.backend.models.staff.Lecturer;
import com.example.assignment.backend.models.staff.Manageable;

public class LecturerServiceImpl implements StaffManager<Manageable> {
    private final StorageManager storageManager;

    public LecturerServiceImpl(StorageManager storageManager) {
        this.storageManager = storageManager;
    }


    @Override
    public void create(Manageable obj) throws InvalidObjectCreationException {
        if (!(obj instanceof CreateStaff)) {
            throw new InvalidObjectCreationException("Invalid object type. Expected CreateStaff.");
        }
        CreateStaff request = (CreateStaff) obj;
        Lecturer newLecturer = new Lecturer();

        // Validate and set first name
        if (request.getFirstName() != null && !request.getFirstName().isBlank()) {
            newLecturer.setFirstName(request.getFirstName());
        } else {
            throw new InvalidObjectCreationException("First name cannot be null or empty.");
        }

        // Validate and set last name
        if (request.getLastName() != null && !request.getLastName().isBlank()) {
            newLecturer.setLastName(request.getLastName());
        } else {
            throw new InvalidObjectCreationException("Last name cannot be null or empty.");
        }

        // Validate and set email
        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            newLecturer.setEmail(request.getEmail());
        } else {
            throw new InvalidObjectCreationException("Email cannot be null or empty.");
        }

        // Validate and set manager ID
//        if (request.getManagerId() != null && !request.getManagerId().isBlank()) {
         newLecturer.setManager(request.getManagerId());
//        } else {
//            throw new InvalidObjectCreationException("Manager ID cannot be null or empty.");
//        }

        // Set contract type and subject area
        if (request.getContractType() != null) {
            newLecturer.setContractType(request.getContractType());
        }

        if (request.getSubjectArea() != null) {
            newLecturer.setSubjectArea(request.getSubjectArea());
        }

        // Save or process newLecturer as needed (e.g., save to a database)
    }




    @Override
    public void update(String id) {
        StaffManager.super.update(id);
    }

    @Override
    public void delete(String id) {
        StaffManager.super.delete(id);
    }

    @Override
    public void get(String id) {
        StaffManager.super.get(id);
    }
}
