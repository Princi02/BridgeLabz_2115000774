package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVFilterExample {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/students.csv";
        int marksThreshold = 80;

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line = reader.readNext(); // Read the header
            System.out.println(String.join(", ", line)); // Print header

            while ((line = reader.readNext()) != null) {
                int marks = Integer.parseInt(line[3]); // Assuming Marks are in the 4th column
                if (marks > marksThreshold) {
                    System.out.println(String.join(", ", line));
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
