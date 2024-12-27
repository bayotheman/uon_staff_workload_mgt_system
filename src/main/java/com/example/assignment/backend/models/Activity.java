package com.example.assignment.backend.models;

import com.example.assignment.backend.exceptions.InvalidYearException;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Adebayo .A. Okutubo
 */
public class Activity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private ActivityType type;
    private String description;
    private int durationInHrs;
    private Semester trimester;
    private int instances;
    private int year;


    public ActivityType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInHrs() {
        return durationInHrs;
    }

    public void setDurationInHrs(int durationInHrs) {
        this.durationInHrs = durationInHrs;
    }

    public Semester getTrimester() {
        return trimester;
    }

    public void setTrimester(Semester trimester) {
        this.trimester = trimester;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >=1000 && year <= 9999) throw new InvalidYearException("Year must be >=1000 && <=9999");
        this.year = year;
    }
}
