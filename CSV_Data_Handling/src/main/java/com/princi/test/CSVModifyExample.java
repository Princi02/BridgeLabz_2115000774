package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVModifyExample {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/employees.csv";
        String outputFile = "src/main/resources/updated_employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String[] line = reader.readNext(); // Read header
            writer.writeNext(line); // Write header to new file

            while ((line = reader.readNext()) != null) {
                String department = line[2]; // Department column
                if (department.equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(line[3]);
                    salary = salary * 1.1; // Increase by 10%
                    line[3] = String.format("%.2f", salary);
                }
                writer.writeNext(line);
            }

            System.out.println("Updated CSV file created: " + outputFile);

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
