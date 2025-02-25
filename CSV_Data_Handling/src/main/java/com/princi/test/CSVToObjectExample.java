package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToObjectExample {

    public static void main(String[] args) {
        String csvFile = "src/main/resources/students.csv";
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] header = reader.readNext(); // Skip header row
            String[] row;

            while ((row = reader.readNext()) != null) {
                // Check if row has exactly 4 columns
                if (row.length < 4) {
                    System.out.println("Skipping invalid row: " + String.join(", ", row));
                    continue;
                }

                try {
                    int id = Integer.parseInt(row[0]);
                    String name = row[1];
                    int age = Integer.parseInt(row[2]);
                    int marks = Integer.parseInt(row[3]);

                    Student student = new Student(id, name, age, marks);
                    students.add(student);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping row with invalid data: " + String.join(", ", row));
                }
            }

            students.forEach(System.out::println);

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}
