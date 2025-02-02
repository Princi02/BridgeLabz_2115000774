package Level1PracticeQuestions;
public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // default constructor
    public HotelBooking(){
        this.guestName = "Priyanshi";
        this.roomType = "Standard";
        this.nights = 1;
    }
    
    // parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    
    // copy constructor
    public HotelBooking(HotelBooking hotel){
        this.guestName = hotel.guestName;
        this.roomType = hotel.roomType;
        this.nights = hotel.nights;
    }

    public void displayBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("Princi", "Standard", 2);
        HotelBooking booking3 = new HotelBooking(booking2);

        System.out.println("By default constructor : ");
        booking1.displayBooking();

        System.out.println("By parameterized constructor : ");
        booking2.displayBooking();

        System.out.println("By copy constructor : ");
        booking3.displayBooking();

    }


    
}
