package com.MiniProject;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setup() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddItem() {
        Item laptop = new Item("Laptop", 1000, 1);
        cart.addItem(laptop);
        List<Item> items = cart.getItems();
        assertTrue(items.contains(laptop));
        assertEquals(1, items.size());

        Item phone = new Item("Phone", 500, 2);
        cart.addItem(phone);
        assertTrue(items.contains(phone));
        assertEquals(2, items.size());
    }

    @Test
    void testRemoveItem() {
        Item tablet = new Item("Tablet", 300, 1);
        cart.addItem(tablet);
        cart.removeItem("Tablet");
        List<Item> items = cart.getItems();
        assertFalse(items.contains(tablet));
        assertEquals(0, items.size());
    }

    @Test
    void testGetSubtotal() {
        cart.addItem(new Item("Mouse", 50, 2));
        cart.addItem(new Item("Keyboard", 100, 1));
        assertEquals(200, cart.getSubtotal());
    }

    @Test
    void testGetSubtotalEmptyCart() {
        assertEquals(0, cart.getSubtotal());
    }

    @Test
    void testRemoveNonExistentItem() {
        cart.addItem(new Item("Monitor", 300, 1));
        cart.removeItem("Headphones");
        List<Item> items = cart.getItems();
        assertEquals(1, items.size());
    }

    @Test
    void testDisplayCart() {
        cart.addItem(new Item("Chair", 150, 2));
        cart.addItem(new Item("Table", 250, 1));
        cart.displayCart();
    }

    // ✅ New Test: Successfully update quantity
    @Test
    void testUpdateQuantitySuccessfully() {
        cart.addItem(new Item("Book", 10.0, 2));
        cart.updateQuantity("Book", 5);
        assertEquals(5, cart.getItems().get(0).getQuantity());
    }

    // ✅ New Test: Update with invalid quantity should throw exception
    @Test
    void testUpdateQuantityWithInvalidValue() {
        cart.addItem(new Item("Pen", 1.0, 3));
        assertThrows(IllegalArgumentException.class, () -> {
            cart.updateQuantity("Pen", 0);
        });
    }
}
