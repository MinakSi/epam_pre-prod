package com.epam.rd.Serhii_Minakov.Task7.part1.repository;

import com.epam.rd.Serhii_Minakov.Task7.part1.DateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is created to store orders which were created by users
 */
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
