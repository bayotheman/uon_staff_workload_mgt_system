package com.example.assignment.backend.services;

import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class AuthenticationService {

    private static AuthenticationService instance;
//    private StaffManager

    public static AuthenticationService getInstance() {

        var result = instance;
        if (result == null) {

            synchronized (AuthenticationService.class) {
                result = instance;
                if(result == null){

                }
            }
        }
        return result;
    }

}
