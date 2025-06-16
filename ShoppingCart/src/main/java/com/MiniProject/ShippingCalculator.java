package com.MiniProject;

public class ShippingCalculator {
    public static double calculateShipping(double subtotal, String shippingMethod) {
        if ("NEXT_DAY".equalsIgnoreCase(shippingMethod)) {
            return 25;
        } else if ("STANDARD".equalsIgnoreCase(shippingMethod)) {
            return (subtotal > 50) ? 0 : 10;
        }
        return 0; // Default case (invalid method handling can be added)
    }
}
