//package com.princi.test;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.everit.json.schema.Schema;
//import org.everit.json.schema.loader.SchemaLoader;
//import org.json.JSONObject;
//
//public class ValidateEmailWithJsonSchema {
//    public static void main(String[] args) {
//        String emailSchema = """
//        {
//            "$schema": "http://json-schema.org/draft-07/schema#",
//            "type": "object",
//            "properties": {
//                "email": {
//                    "type": "string",
//                    "format": "email"
//                }
//            },
//            "required": ["email"]
//        }
//        """;
//
//        String validJson = "{\"email\":\"test@example.com\"}";
//        String invalidJson = "{\"email\":\"invalid-email\"}";
//
//        validateJson(emailSchema, validJson);  // Should be valid
//        validateJson(emailSchema, invalidJson); // Should be invalid
//    }
//
//    public static void validateJson(String schemaStr, String jsonStr) {
//        try {
//            JSONObject jsonSchema = new JSONObject(schemaStr);
//            JSONObject jsonObject = new JSONObject(jsonStr);
//
//            Schema schema = SchemaLoader.load(jsonSchema);
//            schema.validate(jsonObject);
//
//            System.out.println("Valid JSON: " + jsonStr);
//        } catch (Exception e) {
//            System.out.println("Invalid JSON: " + jsonStr);
//            System.out.println("Validation error: " + e.getMessage());
//        }
//    }
//}
