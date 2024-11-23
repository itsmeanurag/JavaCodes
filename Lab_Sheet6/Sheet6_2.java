package Lab_Sheet6;

import java.util.Scanner;

class MovieTheater {
    private final double ticketPrice = 5.0;
    private final double fixedCost = 20.0;
    private final double variableCostPerAttendee = 0.5;

    // Method to calculate profit
    public double calculateTotalProfit(int attendees) {
        double revenue = attendees * ticketPrice;
        double totalCost = fixedCost + (variableCostPerAttendee * attendees);
        return revenue - totalCost;
    }
}

public class Sheet6_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of MovieTheater
        MovieTheater theater = new MovieTheater();

        // Input: number of attendees
        System.out.print("Enter the number of attendees: ");
        int attendees = scanner.nextInt();

        // Calculate and display profit
        double profit = theater.calculateTotalProfit(attendees);
        System.out.printf("The total profit for %d attendees is:Rs %.2f%n", attendees, profit);

        scanner.close();
    }
}

