package QueueInterface;

public class CircularBuffer {
    private int[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    public void add(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
    }

    public int remove() {
        if (size == 0) {
            throw new RuntimeException("Buffer is empty");
        }

        int value = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return value;
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.display();

        cb.add(4);
        cb.display(); 

        System.out.println("Removed: " + cb.remove()); 
        cb.display();

        cb.add(5);
        cb.add(6);
        cb.display(); 
    }
}

