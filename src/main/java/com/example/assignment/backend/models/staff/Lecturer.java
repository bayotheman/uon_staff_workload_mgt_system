package com.example.assignment.backend.models.staff;

import java.io.Serial;
import java.io.Serializable;

public class Lecturer extends Staff implements Manageable {

    private Manager manager;

    public Lecturer(){}

    @Override
    public Manager getManager() {
        return manager;
    }

    @Override
    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
