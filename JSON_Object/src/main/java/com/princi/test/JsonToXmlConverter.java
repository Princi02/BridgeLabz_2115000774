package com.princi.test;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter {
    public static void main(String[] args) throws Exception {
        String json = """
            {
                "name": "John Doe",
                "age": 30,
                "email": "john.doe@example.com",
                "address": {
                    "city": "New York",
                    "zipcode": "10001"
                }
            }
        """;

        // Convert JSON to XML
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        JsonNode jsonNode = jsonMapper.readTree(json);
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        System.out.println(xml);
    }
}
