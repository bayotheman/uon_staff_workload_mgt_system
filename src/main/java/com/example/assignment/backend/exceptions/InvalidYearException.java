package com.example.assignment.backend.exceptions;

public class InvalidYearException extends RuntimeException{
    public InvalidYearException(String message) {
        super(message);
    }
}
