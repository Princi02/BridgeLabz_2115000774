import java.util.*;

class User {
    int id, age;
    String name;
    List<Integer> friends;
    User next;

    User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class FriendNetwork {
    User head;

    void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
            return;
        }
        User temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newUser;
    }

    void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null && userId1 != userId2) {
            if (!user1.friends.contains(userId2)) user1.friends.add(userId2);
            if (!user2.friends.contains(userId1)) user2.friends.add(userId1);
        }
    }

    void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove((Integer) userId2);
            user2.friends.remove((Integer) userId1);
        }
    }

    void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.print(user.name + "'s Friends: ");
            System.out.println(user.friends);
        }
    }

    void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            List<Integer> mutual = new ArrayList<>(user1.friends);
            mutual.retainAll(user2.friends);
            System.out.println("Mutual Friends: " + mutual);
        }
    }

    void searchUser(int userId) {
        User user = findUserById(userId);
        if (user != null) System.out.println(user.id + " | " + user.name + " | Age: " + user.age);
    }

    void searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.id + " | " + temp.name + " | Age: " + temp.age);
            }
            temp = temp.next;
        }
    }

    int countFriends(int userId) {
        User user = findUserById(userId);
        return (user != null) ? user.friends.size() : 0;
    }

    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.id == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.name + " | Age: " + temp.age + " | Friends: " + temp.friends);
            temp = temp.next;
        }
    }
}

public class SocialMedia {
    public static void main(String[] args) {
        FriendNetwork network = new FriendNetwork();
        
        network.addUser(1, "Priyanshi", 25);
        network.addUser(2, "Neha", 22);
        network.addUser(3, "Varsha", 28);
        network.addUser(4, "Aman", 26);

        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);
        network.addFriendConnection(2, 4);

        network.displayAllUsers();
        network.findMutualFriends(1, 2);
        network.displayFriends(1);
        network.removeFriendConnection(1, 2);
        network.displayFriends(1);
    }
}
