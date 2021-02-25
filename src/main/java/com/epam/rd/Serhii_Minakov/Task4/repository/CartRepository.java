package com.epam.rd.Serhii_Minakov.Task4.repository;

import java.util.HashMap;
import java.util.Map;


public class CartRepository {
    private final Map<Integer, Integer> cart;


    public CartRepository() {
        cart = new HashMap<>();

    }

    public boolean add(int id, int amount) {
        cart.put(id, amount);
        return true;
    }

    public Map<Integer, Integer> getCart() {
        return cart;
    }

    public boolean clear() {
        cart.clear();
        return true;
    }
}
