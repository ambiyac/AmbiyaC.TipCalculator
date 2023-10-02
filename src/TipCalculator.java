import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Restaurant Tip Calculator!");

        // Prompt the user to enter the number of people and tip percentage
        System.out.print("Enter the number of people in your group: ");
        int numPeople = scanner.nextInt();
        System.out.print("Enter the tip percentage (0-100): ");
        double tipPercentage = scanner.nextDouble();

        // Initialize variables to keep track of total cost and item costs
        double totalCost = 0.0;
        double itemCost = 0.0;

        // Prompt the user to enter item costs until they enter -1
        while (true) {
            System.out.print("Enter the cost of an item (or -1 to finish): ");
            itemCost = scanner.nextDouble();

            if (itemCost == -1) {
                break; // Exit the loop if -1 is entered
            }

            totalCost += itemCost;
        }

        System.out.println("-------------------------------------------------");

        // Calculate the tip amount and total amount with rounded amount
        double tipAmount = (totalCost * tipPercentage) / 100.0;
        double roundedTotalCost = Math.round(totalCost * 100.0) / 100.0; // Round to two decimal places
        double roundedTipAmount = Math.round(tipAmount * 100.0) / 100.0; // Round to two decimal places
        double totalAmount = roundedTotalCost + roundedTipAmount;

        // Prompt the user to round the total bill to the nearest dollar
        System.out.print("Would you like to round the total bill to the nearest dollar? (yes/no): ");
        String roundChoice = scanner.next();

        if (roundChoice.equalsIgnoreCase("yes")) {
            totalAmount = Math.round(totalAmount); // Round to the nearest dollar
            tipAmount = totalAmount - totalCost; // Recalculate tip based on rounded total
        }

        // Calculate tip per person
        double tipPerPerson = roundedTipAmount / numPeople;

        // Calculate cost per person
        double costPerPerson = roundedTotalCost / numPeople;

        // output
        System.out.println("Summary:");
        System.out.println("Total before tip: $" + roundedTotalCost);
        System.out.println("Total percentage: %" + tipPercentage);
        System.out.println("Total tip: $" + roundedTipAmount);
        System.out.println("Total bill with tip: $" + totalAmount);
        System.out.println("Tip per person: $" + tipPerPerson);
        System.out.println("Total cost per person: " + costPerPerson);

        scanner.close();
    }
}

