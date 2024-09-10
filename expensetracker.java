import java.util.ArrayList;
import java.util.Scanner;

// Class representing an individual expense
class Expense {
    String description; // Description of the expense
    double amount; // Amount of the expense

    // Constructor to initialize an Expense object
    Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    // Override toString method to provide a custom string representation of the
    // Expense
    @Override
    public String toString() {
        return description + ": $" + amount;
    }
}

// Main class to run the Expense Tracker application
public class ExpenseTracker {
    // List to store all expenses
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner to read user input

        // Infinite loop to display the menu and handle user choices
        while (true) {
            // Display menu options
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addExpense(scanner); // Call method to add an expense
                    break;
                case 2:
                    viewExpenses(); // Call method to view all expenses
                    break;
                case 3:
                    calculateTotal(); // Call method to calculate the total expenses
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close(); // Close the scanner
                    return; // Exit the application
                default:
                    System.out.println("Invalid choice. Please choose again."); // Handle invalid input
            }
        }
    }

    // Method to add a new expense
    private static void addExpense(Scanner scanner) {
        // Prompt user for expense description and amount
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        System.out.print("Enter expense amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Create a new Expense object and add it to the list
        expenses.add(new Expense(description, amount));
        System.out.println("Expense added successfully.");
    }

    // Method to view all recorded expenses
    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded."); // Message if no expenses are present
            return;
        }

        System.out.println("\n--- Expense Summary ---");
        // Loop through and print each expense in the list
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // Method to calculate and display the total expense amount
    private static void calculateTotal() {
        double total = 0; // Initialize total amount
        // Loop through the list and sum up all expense amounts
        for (Expense expense : expenses) {
            total += expense.amount;
        }
        // Print the total expense amount
        System.out.printf("Total Expenses: $%.2f%n", total);
    }
}
