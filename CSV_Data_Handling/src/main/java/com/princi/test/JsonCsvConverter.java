package com.princi.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    private static final String JSON_FILE = "src/main/resources/students.json";
    private static final String CSV_FILE = "src/main/resources/students.csv";
    private static final String OUTPUT_JSON_FILE = "src/main/resources/students_output.json";

    public static void main(String[] args) {
        jsonToCsv(JSON_FILE, CSV_FILE);
        csvToJson(CSV_FILE, OUTPUT_JSON_FILE);
    }

    // 1. Convert JSON to CSV
    public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> students = mapper.readValue(
                    new File(jsonFilePath), new TypeReference<List<Map<String, Object>>>() {}
            );

            if (students.isEmpty()) {
                System.out.println("No data found in JSON.");
                return;
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                // Write Header
                Set<String> headers = students.get(0).keySet();
                writer.writeNext(headers.toArray(new String[0]));

                // Write Data Rows
                for (Map<String, Object> student : students) {
                    List<String> row = new ArrayList<>();
                    for (String header : headers) {
                        row.add(String.valueOf(student.get(header)));
                    }
                    writer.writeNext(row.toArray(new String[0]));
                }
                System.out.println("JSON converted to CSV successfully: " + csvFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. Convert CSV to JSON
    public static void csvToJson(String csvFilePath, String jsonFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] headers = reader.readNext(); // Read the header row
            if (headers == null) {
                System.out.println("CSV file is empty.");
                return;
            }
            List<Map<String, String>> students = new ArrayList<>();
            String[] line;
            while ((line = reader.readNext()) != null) { // Possible CsvValidationException
                Map<String, String> student = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], line[i]);
                }
                students.add(student);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), students);
            System.out.println("CSV converted to JSON successfully: " + jsonFilePath);
        } catch (IOException | com.opencsv.exceptions.CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
