import java.util.*;
import java.math.*;
import java.text.*;

public class Main {

    private static final DecimalFormat CURRENCY = new DecimalFormat("₱ #0.00");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Brewtiful Coffee Shop!");
        System.out.println("\nChoose your base coffee:");
        System.out.println("1. Black Coffee (₱100.00)");
        System.out.println("2. Espresso (₱100.00)");
        System.out.print("Enter choice: ");
        int coffeeChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Coffee coffee;
        List<String> ingredients = new ArrayList<>();
        List<BigDecimal> prices = new ArrayList<>();

        if (coffeeChoice == 1) {
            coffee = new BlackCoffee();
            ingredients.add("Black Coffee");
            prices.add(new BigDecimal("100.00"));
        } else {
            coffee = new Espresso();
            ingredients.add("Espresso");
            prices.add(new BigDecimal("100.00"));
        }

        // List of available decorators
        List<String> decoratorOptions = new ArrayList<>();
        decoratorOptions.add("Milk (₱25.00)");
        decoratorOptions.add("Sugar (₱10.00)");
        decoratorOptions.add("Caramel Syrup (₱40.00)");
        decoratorOptions.add("Whipped Cream (₱35.00)");

        System.out.println("\nAdd toppings/decorators (enter numbers separated by commas (e.g., 1,3):");
        System.out.println("0. No Addition");
        for (int i = 0; i < decoratorOptions.size(); i++) {
            System.out.println((i + 1) + ". " + decoratorOptions.get(i));
        }
        System.out.print("Your choices: ");
        String input = scanner.nextLine();

        // Apply decorators based on user input
        if (!input.isEmpty()) {
            String[] selections = input.split(",");
            for (String sel : selections) {
                switch (sel.trim()) {
                    case "0" -> coffee = new NoAddition(coffee); // no addition
                    case "1" -> {
                        coffee = new Milk(coffee);
                        ingredients.add("Milk");
                        prices.add(new BigDecimal("25.00"));
                    }
                    case "2" -> {
                        coffee = new Sugar(coffee);
                        ingredients.add("Sugar");
                        prices.add(new BigDecimal("10.00"));
                    }
                    case "3" -> {
                        coffee = new CaramelSyrup(coffee);
                        ingredients.add("Caramel Syrup");
                        prices.add(new BigDecimal("40.00"));
                    }
                    case "4" -> {
                        coffee = new WhippedCream(coffee);
                        ingredients.add("Whipped Cream");
                        prices.add(new BigDecimal("35.00"));
                    }
                    default -> System.out.println("Invalid choice: " + sel);
                }
            }
        }

        // Print detailed breakdown
        System.out.println("\n--- Your Order Breakdown ---");
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println(String.format("%-15s : %s", ingredients.get(i), CURRENCY.format(prices.get(i))));
            total = total.add(prices.get(i));
        }

        System.out.println("------------------------------");
        System.out.println("Total Cost        : " + CURRENCY.format(total));
        System.out.println("\nFull Description  : " + coffee.getDescription());

        scanner.close();
    }
}
