package com.princi.test;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToCSV {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "your_password";

        String csvFile = "src/main/resources/employees_report.csv";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
             CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            while (resultSet.next()) {
                String[] record = {
                        String.valueOf(resultSet.getInt("employee_id")),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        String.valueOf(resultSet.getDouble("salary"))
                };
                writer.writeNext(record);
            }

            System.out.println("CSV report generated: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
