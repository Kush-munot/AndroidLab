package com.example.foodbookingapp;

import java.util.ArrayList;

public class Cart {

    public static ArrayList<String> cartItems = new ArrayList<>();
    public static ArrayList<Integer> cartPrices = new ArrayList<>();

    public static void addItem(String item, int price) {
        cartItems.add(item);
        cartPrices.add(price);
    }

    public static ArrayList<String> getCartItems() {
        return cartItems;
    }

    public static ArrayList<Integer> getCartPrices() {
        return cartPrices;
    }

    public static void clearCart() {
        cartItems.clear();
        cartPrices.clear();
    }

}
