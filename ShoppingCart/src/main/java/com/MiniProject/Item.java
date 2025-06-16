package com.MiniProject;

/**
 * Represents an item in the shopping cart.
 */
public class Item {
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs an item with the given name, price, and quantity.
     *
     * @param name     the name of the item
     * @param price    the price of a single item
     * @param quantity the number of items
     * @throws IllegalArgumentException if quantity < 1
     */
    public Item(String name, double price, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1.");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets a new quantity for the item.
     *
     * @param quantity the new quantity (must be ≥ 1)
     * @throws IllegalArgumentException if quantity < 1
     */
    public void setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1.");
        }
        this.quantity = quantity;
    }
}
