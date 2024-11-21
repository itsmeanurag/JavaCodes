package Lab_Sheet4;

import java.util.Scanner;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {

        if (password.length() < 5 || password.length() > 12) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                return false;
            }

            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }

            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }

        for (int i = 0; i < password.length() - 2; i++) {
            String pattern = password.substring(i, i + 2);
            if (password.indexOf(pattern, i + 2) != -1) {
                return false;
            }
        }

        return hasLowerCase && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password is not valid.");
        }

    }
}
