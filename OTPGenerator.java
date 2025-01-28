import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {

    // Method to generate a 6-digit OTP number
    public static int generateOTP() {
        int otp = (int) (Math.random() * 900000) + 100000; // Generates a number between 100000 and 999999
        return otp;
    }

    // Method to check if all OTPs generated are unique
    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> otpSet = new HashSet<>();
        for (int otp : otps) {
            if (!otpSet.add(otp)) {
                return false; // If the set fails to add the OTP, it means the OTP is a duplicate
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10]; // Array to store the 10 generated OTPs

        // Generate 10 OTP numbers and store them in the array
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }

        // Check if all OTPs are unique
        if (areOTPsUnique(otps)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("There are duplicate OTPs.");
        }
    }
}
