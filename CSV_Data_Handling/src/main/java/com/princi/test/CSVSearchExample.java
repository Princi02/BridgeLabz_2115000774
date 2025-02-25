package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CSVSearchExample {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/employees.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean recordFound = false;

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line = reader.readNext(); // Read header

            while ((line = reader.readNext()) != null) {
                String name = line[1]; // Assuming Name is in the 2nd column
                if (name.equalsIgnoreCase(searchName)) {
                    String department = line[2];
                    String salary = line[3];
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    recordFound = true;
                    break;
                }
            }

            if (!recordFound) {
                System.out.println("Employee not found.");
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
