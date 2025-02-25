package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/employees.csv";
        int chunkSize = 100;
        int recordCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            int lineNumber = 0;

            while ((line = reader.readNext()) != null) {
                // Skip header if needed
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }

                // Process the line (For example, print or store the data)
                System.out.println("Processing: " + String.join(", ", line));

                recordCount++;
                lineNumber++;

                // Display count after every chunk
                if (recordCount % chunkSize == 0) {
                    System.out.println("Processed " + recordCount + " records so far...");
                }
            }
            System.out.println("Total records processed: " + (recordCount));
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
