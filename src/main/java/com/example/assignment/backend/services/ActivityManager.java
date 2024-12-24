package com.example.assignment.backend.services;

import com.example.assignment.backend.exceptions.NoImplementationException;
import com.example.assignment.backend.models.Activity;

public interface ActivityManager<T> {


    default Activity create(T obj){
        throw new NoImplementationException("");
    }
   default  Activity update(String id){
        throw new NoImplementationException("");
    }
    default void delete(String id){
        throw new NoImplementationException("");
    }
    default Activity get(String id){
        throw new NoImplementationException("");
    }
}
