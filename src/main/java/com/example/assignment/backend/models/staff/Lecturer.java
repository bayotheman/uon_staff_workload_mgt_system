package com.example.assignment.backend.models.staff;

import java.io.Serial;
import java.io.Serializable;

public class Lecturer extends Staff implements Manageable
//        , Serializable
{

//    @Serial
//    private static final long serialVersionUID = 1L;
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
