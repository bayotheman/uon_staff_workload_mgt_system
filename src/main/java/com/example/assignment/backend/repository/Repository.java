package com.example.assignment.backend.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Repository<K, V> {

    void save(K key, V object) throws IOException;
    void delete(K object) throws IOException;
     V get(K id) throws IOException, ClassNotFoundException;

     default List<V> findAll() throws IOException, ClassNotFoundException {
         return new ArrayList<>();
     }

     default void deleteAll() throws IOException, ClassNotFoundException {

     }
}
