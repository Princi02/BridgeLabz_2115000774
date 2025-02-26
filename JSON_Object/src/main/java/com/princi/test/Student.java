package com.princi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<String> subjects;

    // Default constructor (required by Jackson)
    public Student() {}

    // Parameterized constructor
    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }


    public String getName() { return name; }
    public int getAge() { return age; }
    public List<String> getSubjects() { return subjects; }

    public static void main(String[] args) throws Exception {
        Student student = new Student("John Doe", 20, Arrays.asList("Math", "Physics", "Computer Science"));
        ObjectMapper mapper = new ObjectMapper();

        // Serialize to JSON
        String jsonString = mapper.writeValueAsString(student);
        System.out.println(jsonString);
    }
}
