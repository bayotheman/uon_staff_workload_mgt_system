package com.example.assignment.backend.models;


import java.io.Serial;
import java.io.Serializable;

public class Semester implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String info;
    private String session;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
