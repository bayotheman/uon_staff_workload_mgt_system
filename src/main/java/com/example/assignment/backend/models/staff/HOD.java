package com.example.assignment.backend.models.staff;

import java.io.Serial;
import java.io.Serializable;

public class HOD extends Manager implements Manageable {

    private Manager manager;

    @Override
    public Manager getManager() {
        return manager;
    }

    @Override
    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
