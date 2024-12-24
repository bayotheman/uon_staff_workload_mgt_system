package com.example.assignment.backend.models;

public enum StaffContractType {
    FULL_TIME("Full-Time"), PART_TIME("Part-Time");
    private final String value;
    StaffContractType(String s) {
        value =s ;
    }
    String getValue(){
        return value;
    }
}
