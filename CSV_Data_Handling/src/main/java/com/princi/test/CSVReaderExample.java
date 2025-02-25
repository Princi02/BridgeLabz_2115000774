package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderExample {

    public static void main(String[] args) {
        String csvFile = "src/main/resources/students.csv";
// Path to your CSV file

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] record;

            // Read and print each row in a structured format
            while ((record = reader.readNext()) != null) {
                System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n",
                        record[0], record[1], record[2], record[3]);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
