public class PasswordValidator {

    // Validates if the password meets the requirements
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (hasUppercase && hasDigit) {
                return true;
            }
        }
        return false;
    }
}
