package com.example.assignment.backend.services;

import com.example.assignment.backend.exceptions.InvalidObjectCreationException;
import com.example.assignment.backend.exceptions.NoImplementationException;

public interface StaffManager<T> {


    default void create(T obj) throws InvalidObjectCreationException {
        throw new NoImplementationException("");
    }

    default void update(String id){
        throw new NoImplementationException("");
    }

    default void delete(String id){
        throw new NoImplementationException("");
    }

    default void get(String id){
        throw new NoImplementationException("");
    }

}
