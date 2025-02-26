package com.princi.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJsonByAge2 {
    public static void main(String[] args) throws Exception {
        String jsonArray = "["
                + "{\"name\":\"John\",\"age\":30},"
                + "{\"name\":\"Alice\",\"age\":22},"
                + "{\"name\":\"Bob\",\"age\":27}"
                + "]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonArray);
        ArrayNode filteredArray = mapper.createArrayNode();

        for (JsonNode node : root) {
            if (node.path("age").asInt() > 25) {
                filteredArray.add(node);
            }
        }

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredArray));
    }
}

