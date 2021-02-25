package com.epam.rd.Serhii_Minakov.Task4.repository;

import com.epam.rd.Serhii_Minakov.Task4.DateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrderRepository {
    private final Map<DateTime, Map<Integer, Integer>> orders;

    public OrderRepository() {
        orders = new TreeMap<>();
    }

    public void add(DateTime dateTime, Map<Integer, Integer> map) {
        orders.put(dateTime, new HashMap<>(map));
    }

    public Map<DateTime, Map<Integer, Integer>> getOrders() {
        return orders;
    }
}
