package com.example.assignment.backend.services;

import com.example.assignment.backend.exceptions.InvalidObjectCreationException;
import com.example.assignment.backend.exceptions.NoImplementationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface StaffManager<T> {


    default void create(T obj) throws InvalidObjectCreationException, IOException {
        throw new NoImplementationException("");
    }

    default void update(String id, T data) throws IOException, ClassNotFoundException {
        throw new NoImplementationException("");
    }

    default void delete(String id) throws IOException {
        throw new NoImplementationException("");
    }

    default T get(String id) throws IOException, ClassNotFoundException {
        throw new NoImplementationException("");
    }

    default List<T> findAll() throws IOException, ClassNotFoundException {
        return new ArrayList<T>();
    }

}
