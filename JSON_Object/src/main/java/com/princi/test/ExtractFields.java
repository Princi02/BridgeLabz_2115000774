package com.princi.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractFields {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("src/main/resources/user.json"));

        String name = root.path("name").asText();
        String email = root.path("email").asText();

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

