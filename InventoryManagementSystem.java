import java.util.*;

class Item {
    String name;
    int id, qty, price;
    Item nxt;

    Item(int id, String name, int qty, int price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.nxt = null;
    }
}

class Inventory {
    Item head;

    void add_Beg(int id, String name, int qty, int price) {
        Item i = new Item(id, name, qty, price);
        i.nxt = head;
        head = i;
    }

    void add_End(int id, String name, int qty, int price) {
        Item i = new Item(id, name, qty, price);
        if (head == null) {
            head = i;
            return;
        }
        Item tmp = head;
        while (tmp.nxt != null) tmp = tmp.nxt;
        tmp.nxt = i;
    }

    void add_Pos(int id, String name, int qty, int price, int pos) {
        if (pos == 1) {
            add_Beg(id, name, qty, price);
            return;
        }
        Item i = new Item(id, name, qty, price);
        Item tmp = head;
        for (int j = 1; tmp != null && j < pos - 1; j++) tmp = tmp.nxt;
        if (tmp == null) return;
        i.nxt = tmp.nxt;
        tmp.nxt = i;
    }

    void del(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.nxt;
            return;
        }
        Item tmp = head, prev = null;
        while (tmp != null && tmp.id != id) {
            prev = tmp;
            tmp = tmp.nxt;
        }
        if (tmp == null) return;
        prev.nxt = tmp.nxt;
    }

    void updateQty(int id, int qty) {
        Item tmp = head;
        while (tmp != null) {
            if (tmp.id == id) {
                tmp.qty = qty;
                return;
            }
            tmp = tmp.nxt;
        }
    }

    void totalVal() {
        int total = 0;
        for (Item tmp = head; tmp != null; tmp = tmp.nxt) total += tmp.qty * tmp.price;
    }

    void sortByName() {
        for (Item i = head; i != null; i = i.nxt)
            for (Item j = head; j.nxt != null; j = j.nxt)
                if (j.name.compareToIgnoreCase(j.nxt.name) > 0) swap(j, j.nxt);
    }

    void sortByPrice() {
        for (Item i = head; i != null; i = i.nxt)
            for (Item j = head; j.nxt != null; j = j.nxt)
                if (j.price > j.nxt.price) swap(j, j.nxt);
    
    }

    void swap(Item a, Item b) {
        int tID = a.id, tQty = a.qty, tPrice = a.price;
        String tName = a.name;
        a.id = b.id; a.qty = b.qty; a.price = b.price; a.name = b.name;
        b.id = tID; b.qty = tQty; b.price = tPrice; b.name = tName;
    }

    void display() {
        for (Item tmp = head; tmp != null; tmp = tmp.nxt)
            System.out.println(tmp.id + " | " + tmp.name + " | " + tmp.qty + " | " + tmp.price);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.add_End(1, "Laptop", 5, 60000);
        inv.add_Beg(2, "Phone", 10, 30000);
        inv.add_Pos(3, "Tablet", 8, 20000, 2);
        inv.add_End(4, "Monitor", 4, 15000);
        inv.display();
        inv.updateQty(1, 7);
    }
}
