import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int SIZE = 16; // Default number of buckets
    private LinkedList<Entry<K, V>>[] map;

    // Constructor
    public CustomHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }
        bucket.add(new Entry<>(key, value)); // Insert new key-value pair
    }

    // Retrieve a value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    // Entry class (Key-Value Pair)
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Test the Custom HashMap
    public static void main(String[] args) {
        CustomHashMap<String, Integer> myMap = new CustomHashMap<>();

        myMap.put("One", 1);
        myMap.put("Two", 2);
        myMap.put("Three", 3);

        System.out.println("Value for 'One': " + myMap.get("One")); // Output: 1
        System.out.println("Value for 'Two': " + myMap.get("Two")); // Output: 2

        myMap.remove("Two");
        System.out.println("Value for 'Two' after removal: " + myMap.get("Two")); // Output: null
    }
}
