package com.princi.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ValidateJsonStructure {
    public static void main(String[] args) throws Exception {
        String jsonString = "{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonString);

        boolean isValid = jsonNode.has("name") && jsonNode.has("email");

        System.out.println("Is JSON valid? " + isValid);
    }
}

