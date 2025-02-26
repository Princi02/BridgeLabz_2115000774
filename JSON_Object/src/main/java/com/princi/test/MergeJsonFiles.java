package com.princi.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON files into JsonNode objects
        JsonNode json1 = mapper.readTree(new File("data/file1.json"));
        JsonNode json2 = mapper.readTree(new File("data/file2.json"));

        // Merge the two JSON objects
        ObjectNode mergedJson = mapper.createObjectNode();
        mergedJson.setAll((ObjectNode) json1);
        mergedJson.setAll((ObjectNode) json2);

        // Output the merged JSON
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
    }
}

