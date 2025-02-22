import java.util.regex.Pattern;

public class UserRegistration {

    // Registers a user if inputs are valid
    public String registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (password == null || !isValidPassword(password)) {
            throw new IllegalArgumentException("Password must have at least 8 characters, including 1 uppercase, 1 lowercase, and 1 digit.");
        }
        return "User registered successfully!";
    }

    // Validates the email format using regex
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    // Validates the password strength
    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*");
    }
}
