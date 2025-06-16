package com.MiniProject;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " added. Total items: " + items.size());
    }

    public void removeItem(String itemName) {
        boolean removed = items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
        if (!removed) {
            System.out.println("Item not found in the cart.");
        }
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Shopping cart is empty.");
        } else {
            System.out.println("Cart Contents:");
            for (Item item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice() + " x " + item.getQuantity());
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateQuantity(String itemName, int newQuantity) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setQuantity(newQuantity);
                System.out.println("Updated quantity of " + itemName + " to " + newQuantity);
                return;
            }
        }
        System.out.println("Item \"" + itemName + "\" not found in cart.");
    }
}
