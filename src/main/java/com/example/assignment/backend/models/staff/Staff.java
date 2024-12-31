package com.example.assignment.backend.models.staff;

import com.example.assignment.backend.models.Activity;
import com.example.assignment.backend.models.StaffContractType;
import com.example.assignment.backend.models.Workload;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public abstract class Staff
        implements Serializable
{

    @Serial
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String id;
    private String subjectArea;
    Manager manager;
    private StaffContractType contractType;

    private Workload schedule = new Workload();

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

    public StaffContractType getContractType() {
        return contractType;
    }

    public void setContractType(StaffContractType contractType) {
        this.contractType = contractType;
    }

    public Workload getSchedule() {
        return schedule;
    }

    public void setSchedule(Workload schedule) {
        this.schedule = schedule;
    }

    public void addActivity(Activity activity){
        schedule.addActivity(activity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return firstName.equals(staff.firstName) && lastName.equals(staff.lastName) && email.equals(staff.email) && id.equals(staff.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, id);
    }
}
