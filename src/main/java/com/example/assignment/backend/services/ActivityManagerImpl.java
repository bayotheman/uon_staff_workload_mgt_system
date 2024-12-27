package com.example.assignment.backend.services;

import com.example.assignment.backend.models.Activity;

/**
 * Handles Activity management such as creation, update, read and deletion operations
 */

public class ActivityManagerImpl implements ActivityManager<Activity> {
//    private final FileManager fileManager;


    public ActivityManagerImpl() {

    }

    @Override
    public Activity create(Activity obj) {
        return ActivityManager.super.create(obj);
    }

    @Override
    public Activity update(String id) {
        return ActivityManager.super.update(id);
    }

    @Override
    public void delete(String id) {
        ActivityManager.super.delete(id);
    }

    @Override
    public Activity get(String id) {
        return ActivityManager.super.get(id);
    }
}
