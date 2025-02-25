package com.princi.test;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriterExample {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/employees.csv";
        String[] header = { "ID", "Name", "Department", "Salary" };
        String[][] data = {
                { "1", "Priyanshi", "HR", "50000" },
                { "2", "Aman", "Finance", "60000" },
                { "3", "Varsha", "IT", "75000" },
                { "4", "Neha", "Marketing", "55000" },
                { "5", "Krati", "Sales", "65000" }
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            writer.writeNext(header);

            // Write all employee records
            for (String[] row : data) {
                writer.writeNext(row);
            }

            System.out.println("Data written to " + csvFile + " successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

