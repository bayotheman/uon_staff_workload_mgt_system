package com.example.assignment.backend.models.dto;

import com.example.assignment.backend.models.StaffContractType;
import com.example.assignment.backend.models.staff.Manageable;

public class CreateStaff implements Manageable {
    private String firstName;
    private String lastName;
    private String email;
    private String id;
    private String subjectArea;
    private String managerId;
    private StaffContractType contractType;


    @Override
    public String getManagerId() {
        return managerId;
    }

    @Override
    public void setManager(String id) {
        managerId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

//    public String getManagerId() {
//        return managerId;
//    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public StaffContractType getContractType() {
        return contractType;
    }

    public void setContractType(StaffContractType contractType) {
        this.contractType = contractType;
    }
}
