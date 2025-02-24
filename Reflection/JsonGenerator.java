package Reflection;

import java.lang.reflect.Field;

class Person {
    private String name = "John";
    private int age = 30;
    private boolean active = true;
}

public class JsonGenerator {
    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            String name = fields[i].getName();
            Object value = fields[i].get(obj);
            json.append("\"").append(name).append("\":");

            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        String json = toJson(person);
        System.out.println(json);
    }
}

