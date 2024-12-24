package com.example.assignment.backend.models.activity;

import com.example.assignment.backend.exceptions.InvalidYearException;
import com.example.assignment.backend.models.Semester;

public interface Activities {

    public String getDescription() ;

//    public void setDescription(String description) ;

    int getDurationInHrs();

//    void setDurationInHrs(int durationInHrs) ;

    Semester getTrimester();

    public void setTrimester(Semester trimester);

    public int getInstances();

//    public void setInstances(int instances);

    public int getYear() ;

//    public void setYear(int year) ;
}
