package Lab_Sheet4;

import java.util.Scanner;

public class PerfectStringCheckerArray {

    public static boolean isPerfectString(String str) {

        boolean[] visited = new boolean[26];

        for (char ch : str.toCharArray()) {

            if (ch >= 'a' && ch <= 'z') {
                int index = ch - 'a';
                if (visited[index]) {

                    return false;
                }
                visited[index] = true;
            }

            else if (ch >= 'A' && ch <= 'Z') {
                int index = ch - 'A';
                if (visited[index]) {

                    return false;
                }
                visited[index] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPerfectString(input)) {
            System.out.println("The string is a perfect string.");
        } else {
            System.out.println("The string is not a perfect string.");
        }
    }
}
