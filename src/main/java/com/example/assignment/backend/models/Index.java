package com.example.assignment.backend.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Index<K, V> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private String id;
    private String name;
    private Map<K, V> map = new HashMap<>();


}
