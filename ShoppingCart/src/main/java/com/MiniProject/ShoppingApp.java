package com.MiniProject;

import java.util.Scanner;

public class ShoppingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String state;
        String shippingMethod;
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. View Cart");
            System.out.println("3. Remove Item");
            System.out.println("4. Modify Product Quantity");
            System.out.println("5. Get Total");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.next(); // clear invalid token
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    cart.addItem(new Item(name, price, quantity));
                }
                case 2 -> cart.displayCart();
                case 3 -> {
                    System.out.print("Enter item name to remove: ");
                    String removeItem = scanner.nextLine();
                    cart.removeItem(removeItem);
                }
                case 4 -> {
                    System.out.print("Enter item name to modify: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();
                    cart.updateQuantity(itemName, newQty);
                }
                case 5 -> {
                    System.out.print("Enter your state (e.g., IL, CA, NY): ");
                    state = scanner.next();
                    System.out.print("Enter shipping method (STANDARD/NEXT_DAY): ");
                    shippingMethod = scanner.next();

                    double subtotal = cart.getSubtotal();
                    double tax = TaxCalculator.calculateTax(subtotal, state);
                    double shipping = ShippingCalculator.calculateShipping(subtotal, shippingMethod);
                    double total = subtotal + tax + shipping;

                    System.out.printf("Subtotal: $%.2f, Tax: $%.2f, Shipping: $%.2f, Total: $%.2f\n",
                            subtotal, tax, shipping, total);
                }
                case 6 -> {
                    System.out.println("✅ Order placed successfully!");
                    System.out.println("🙏 Thanks for shopping a lot!");
                    // Do NOT exit — let the user continue if they want
                }
                case 7 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // now exit the app
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
