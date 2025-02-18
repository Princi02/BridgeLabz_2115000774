import java.util.*;
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}


class Electronics extends WarehouseItem{
    public Electronics(String name){
        super(name);
    }
}
class Groceries  extends WarehouseItem{
    public Groceries (String name){
        super(name);
    }
}
class Furniture  extends WarehouseItem{
    public Furniture (String name){
        super(name);
    }
}


class Storage<T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }

    public List<T> getItems(){
        return items;
    }
}


class WarehouseUtility {
    public static void displayItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            System.out.println(item);
        }
    }
}


public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics:");
        WarehouseUtility.displayItems(electronicsStorage.getItems());
        
        System.out.println("\nGroceries:");
        WarehouseUtility.displayItems(groceriesStorage.getItems());
        
        System.out.println("\nFurniture:");
        WarehouseUtility.displayItems(furnitureStorage.getItems());
    }
}
