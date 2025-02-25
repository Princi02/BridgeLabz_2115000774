package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/students.csv";

        Map<String, String> records = new HashMap<>();
        List<String> duplicates = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            reader.readNext(); // Skip header

            while ((line = reader.readNext()) != null) {
                String id = line[0];
                String record = String.join(", ", line);

                if (records.containsKey(id)) {
                    duplicates.add(record);
                } else {
                    records.put(id, record);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                duplicates.forEach(System.out::println);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
