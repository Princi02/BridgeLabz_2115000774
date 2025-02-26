package com.princi.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ConvertListToJsonArray {
    static class Car {
        private String brand;
        private String model;
        private int year;

        public Car() {}
        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        public String getBrand() { return brand; }
        public String getModel() { return model; }
        public int getYear() { return year; }
    }

    public static void main(String[] args) throws Exception {
        List<Car> cars = Arrays.asList(
                new Car("Tesla", "Model S", 2023),
                new Car("Ford", "Mustang", 2022)
        );

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(cars);

        System.out.println(jsonArray);
    }
}

