package com.MiniProject;  

public class TaxCalculator {
    private static final double TAX_RATE = 0.06;
    
    public static double calculateTax(double amount, String state) {
        if (state.equals("IL") || state.equals("CA") || state.equals("NY")) {
            return amount * TAX_RATE;
        }
        return 0;
    }
}
