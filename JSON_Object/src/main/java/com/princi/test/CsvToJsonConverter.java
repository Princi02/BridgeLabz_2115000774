package com.princi.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;

public class CsvToJsonConverter {
    public static void main(String[] args) throws Exception {
        File csvFile = new File("data.csv");

        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();

        JsonNode jsonTree = csvMapper.readerFor(JsonNode.class).with(csvSchema).readTree(csvFile);

        ObjectMapper jsonMapper = new ObjectMapper();
        String jsonString = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonTree);

        System.out.println(jsonString);
    }
}

