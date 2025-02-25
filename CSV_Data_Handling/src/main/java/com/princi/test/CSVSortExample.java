package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CSVSortExample {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/employees.csv";
        List<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line = reader.readNext(); // Read header
            if (line != null) {
                records.add(line); // Add header to the list
            }

            while ((line = reader.readNext()) != null) {
                records.add(line); // Add each row to the list
            }

            // Sort records by Salary in descending order (index 3 is Salary)
            records.stream()
                    .skip(1) // Skip the header
                    .sorted(Comparator.comparingDouble((String[] row) -> Double.parseDouble(row[3])).reversed())
                    .limit(5) // Get top 5 highest-paid employees
                    .forEach(row -> System.out.println(String.join(", ", row)));

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
