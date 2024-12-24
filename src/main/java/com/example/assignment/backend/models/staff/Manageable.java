package com.example.assignment.backend.models.staff;

/**
 *
 */
public interface Manageable {
    default Manager getManager(){
        return null;
    }
   default void setManager(Manager manager){

    }

    default String getManagerId(){
        return null;
    }

    default void setManager(String id){

    }

}
