import java.util.*;

class Ticket {
    int ticketId;
    String customerName, movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservation {
    Ticket head = null, tail = null;
    int count = 0;

    void bookTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head; // Circular connection
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular link
        }
        count++;
    }

    void cancelTicket(int ticketId) {
        if (head == null) return;

        Ticket temp = head, prev = null;
        if (head.ticketId == ticketId) { 
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            count--;
            return;
        }

        temp = head;
        while (temp.next != head) {
            if (temp.next.ticketId == ticketId) {
                temp.next = temp.next.next;
                if (tail.ticketId == ticketId) tail = temp;
                count--;
                return;
            }
            temp = temp.next;
        }
    }

    void displayTickets() {
        if (head == null) return;

        Ticket temp = head;
        while (true) {
            System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNumber + " | " + temp.bookingTime);
            temp = temp.next;
            if (temp == head) break;
        }
    }

    void searchByCustomer(String customerName) {
        if (head == null) return;

        Ticket temp = head;
        while (true) {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNumber + " | " + temp.bookingTime);
            }
            temp = temp.next;
            if (temp == head) break;
        }
    }

    void searchByMovie(String movieName) {
        if (head == null) return;

        Ticket temp = head;
        while (true) {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNumber + " | " + temp.bookingTime);
            }
            temp = temp.next;
            if (temp == head) break;
        }
    }

    int totalTickets() {
        return count;
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();
        
        system.bookTicket(1, "Priyanshi", "The age of adeline", 12, "10:00 AM");
        system.bookTicket(2, "Aman", "Raazi", 15, "12:00 PM");
        system.bookTicket(3, "Yash", "Inception", 8, "10:00 AM");

        system.displayTickets();

        system.cancelTicket(2);
        system.displayTickets();

        system.searchByCustomer("Priyanshi");
        system.searchByMovie("Inception");

        System.out.println("Total Tickets: " + system.totalTickets());
    }
}
