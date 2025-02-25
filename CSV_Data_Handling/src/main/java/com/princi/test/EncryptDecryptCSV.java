package com.princi.test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    private static final String CSV_FILE = "src/main/resources/employees2.csv";
    private static final String ENCRYPTED_CSV_FILE = "src/main/resources/encrypted_employees.csv";
    private static final String SECRET_KEY = "MySecretKey12345"; // 16-char key for AES

    public static void main(String[] args) {
        writeEncryptedCSV(CSV_FILE, ENCRYPTED_CSV_FILE);
        readDecryptedCSV(ENCRYPTED_CSV_FILE);
    }

    // 1. Encrypt and write to CSV
    public static void writeEncryptedCSV(String inputCsv, String outputCsv) {
        try (CSVReader reader = new CSVReader(new FileReader(inputCsv));
             CSVWriter writer = new CSVWriter(new FileWriter(outputCsv))) {

            String[] headers = reader.readNext(); // Read header
            if (headers != null) {
                writer.writeNext(headers);
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                // Encrypt sensitive fields (Salary and Email)
                row[3] = encrypt(row[3], SECRET_KEY); // Encrypt Salary
                row[4] = encrypt(row[4], SECRET_KEY); // Encrypt Email
                writer.writeNext(row);
            }
            System.out.println("Data encrypted and written to CSV: " + outputCsv);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 2. Read and decrypt from CSV
    public static void readDecryptedCSV(String inputCsv) {
        try (CSVReader reader = new CSVReader(new FileReader(inputCsv))) {

            String[] headers = reader.readNext(); // Read header
            if (headers != null) {
                System.out.println(String.join(", ", headers));
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                // Decrypt sensitive fields (Salary and Email)
                row[3] = decrypt(row[3], SECRET_KEY); // Decrypt Salary
                row[4] = decrypt(row[4], SECRET_KEY); // Decrypt Email
                System.out.println(String.join(", ", row));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // AES Encryption
    public static String encrypt(String data, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // AES Decryption
    public static String decrypt(String encryptedData, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
}
