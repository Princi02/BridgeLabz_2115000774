package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVRowCountExample {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/students.csv";
        int rowCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Skip the header row
            reader.readNext();

            while (reader.readNext() != null) {
                rowCount++;
            }

            System.out.println("Total records (excluding header): " + rowCount);

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
