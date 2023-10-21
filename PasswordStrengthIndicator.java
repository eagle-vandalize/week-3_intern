import java.util.Scanner;

public class PasswordStrengthIndicator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String password;
            
            do {
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                
                String strength = getPasswordStrength(password);
                System.out.println("Strength: " + strength);

                if (!strength.equals("Strong")) {
                    // Provide a sarcastic message for weak or medium attempts
                    System.out.println("Nice try, but you can do better!");
                }
            } while (!passwordIsStrong(password));
        }
        System.out.println("Congratulations! Your password is strong and set successfully");
    }

    public static String getPasswordStrength(String password) {
        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        if (length > 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            return "Strong";
        } else if (length > 6) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public static boolean passwordIsStrong(String password) {
        return getPasswordStrength(password).equals("Strong");
    }
}
