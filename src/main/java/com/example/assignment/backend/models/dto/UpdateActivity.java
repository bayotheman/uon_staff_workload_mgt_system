package com.example.assignment.backend.models.dto;

import com.example.assignment.backend.models.ActivityType;
import com.example.assignment.backend.models.Semester;

public class UpdateActivity {
    private String staffId;
    private String id;
    private ActivityType type;
    private String description;
    private int durationInHrs;
    private Semester trimester;
    private int instances;
    private int year;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ActivityType getType() {
        return type;
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
        this.year = year;
    }
}
