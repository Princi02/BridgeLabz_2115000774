package Reflection;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
    
    public static String getApiKey() {
        return API_KEY;
    }
}

public class AccessModifyStaticField {
    public static void main(String[] args) throws Exception {
        Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);
        
        System.out.println("Original API_KEY: " + Configuration.getApiKey());
        
        apiKeyField.set(null, "UPDATED_API_KEY");
        
        System.out.println("Modified API_KEY: " + Configuration.getApiKey());
    }
}

