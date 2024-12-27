package com.example.assignment.backend.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the work loads of staffs at the university.
 * @author Adebayo. A. Okutubo
 */
public class Workload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<Activity> activities = new ArrayList<>();


    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivities(Collection<Activity> activityCollections){
        activities.addAll(activityCollections);
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }
}
