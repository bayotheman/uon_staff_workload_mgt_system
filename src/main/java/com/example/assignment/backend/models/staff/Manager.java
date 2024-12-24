package com.example.assignment.backend.models.staff;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Manager extends Staff implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
     List<Manageable> members = new ArrayList<>();
     private void addMember(Manageable member){
         members.add(member);
     }
//     private void removeMember(String )
//    private  String username;
//    private String password;
//
//    public void setUsername(String email) {
//
//    }
//
//
//    public void setPassword(String password) {
//
//    }
//
//
//    public String getUsername() {
//        return null;
//    }
//
//    public String getPassword() {
//        return null;
//    }
}
