package com.mediawave.mediawave.model;

import java.util.Map;


public class Student {
    private String id;
    private String name;
    private Map<String, Integer> subjectMarks;

    // Constructors, getters, and setters
    // Constructor
    public Student(){}
    public Student(String id, String name, Map<String, Integer> subjectMarks) {
        this.id = id;
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubject(Map<String, Integer> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", subjectMarks=" + subjectMarks +
                '}';
    }
    // Other methods as needed
}
