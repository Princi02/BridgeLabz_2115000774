package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String csvFile1 = "src/main/resources/students.csv";
        String csvFile2 = "src/main/resources/students2.csv";
        String outputCsv = "src/main/resources/merged_students.csv";

        Map<String, String[]> dataMap = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(csvFile1));
             CSVReader reader2 = new CSVReader(new FileReader(csvFile2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputCsv))) {

            String[] header1 = reader1.readNext(); // Read header from first CSV
            String[] header2 = reader2.readNext(); // Read header from second CSV

            String[] mergedHeader = new String[]{"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(mergedHeader); // Write merged header

            String[] row;
            while ((row = reader1.readNext()) != null) {
                dataMap.put(row[0], row); // Store data from first CSV using ID as key
            }

            while ((row = reader2.readNext()) != null) {
                String id = row[0];
                if (dataMap.containsKey(id)) {
                    String[] student1Data = dataMap.get(id);
                    String[] mergedRow = new String[]{
                            id,
                            student1Data[1], // Name from first CSV
                            student1Data[2], // Age from first CSV
                            row[1], // Marks from second CSV
                            row[2]  // Grade from second CSV
                    };
                    writer.writeNext(mergedRow); // Write merged row to new CSV
                }
            }

            System.out.println("Merged CSV created successfully!");

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
