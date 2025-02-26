import com.fasterxml.jackson.databind.ObjectMapper;

public class Car {
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

    public static void main(String[] args) throws Exception {
        Car car = new Car("Tesla", "Model S", 2023);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(car);
        System.out.println(jsonString);
    }
}
