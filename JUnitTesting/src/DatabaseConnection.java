public class DatabaseConnection {

    private boolean connected = false;

    public void connect() {
        connected = true;
        System.out.println("Connected to the database.");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Disconnected from the database.");
    }

    public boolean isConnected() {
        return connected;
    }
}
