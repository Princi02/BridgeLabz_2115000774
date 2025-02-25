package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class CSVValidationExample {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final String PHONE_REGEX = "^\\d{10}$";

    public static void main(String[] args) {
        String csvFile = "src/main/resources/employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] header = reader.readNext(); // Read header
            if (header != null) {
                System.out.println(String.join(", ", header));
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                String email = row[2];
                String phoneNumber = row[3];

                boolean validEmail = Pattern.matches(EMAIL_REGEX, email);
                boolean validPhone = Pattern.matches(PHONE_REGEX, phoneNumber);

                if (!validEmail) {
                    System.out.println("Invalid Email: " + String.join(", ", row));
                }

                if (!validPhone) {
                    System.out.println("Invalid Phone Number: " + String.join(", ", row));
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
