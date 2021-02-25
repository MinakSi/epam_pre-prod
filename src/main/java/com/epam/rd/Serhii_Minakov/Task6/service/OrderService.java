package com.epam.rd.Serhii_Minakov.Task6.service;

import com.epam.rd.Serhii_Minakov.Task6.DateTime;
import com.epam.rd.Serhii_Minakov.Task6.repository.OrderRepository;

import java.time.Duration;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class is created to manipulate with orders
 */
public class OrderService {
    private final OrderRepository orderRepository;
    private final GoodsService goodsService;
    private final CartService cartService;
    public static final String NO_ORDERS_MSG = "No orders were added";

    public OrderService(OrderRepository orderRepository, CartService cartService, GoodsService goodsService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.goodsService = goodsService;
    }

    /**
     * Creates a new order, adding it to the order repository
     */
    public void buy() {
        System.out.println("Enter date, time, please");
        Scanner scanner = new Scanner(System.in);
        String dateTime = scanner.nextLine();
        orderRepository.add(new DateTime(dateTime), cartService.getCart());
        System.out.println("Order created. Total: " + cost() + " UAH");
        cartService.clear();
    }

    private double cost() {
        double sum = 0;
        for (Map.Entry<Integer, Integer> entry : cartService.getCart().entrySet()) {
            sum += goodsService.get(entry.getKey()).getPrice() * entry.getValue();
        }
        return sum;
    }

    /**
     * Shows orders that were created between the lower and higher limits
     */
    public void showOrdersInRange() {
        Map<DateTime, Map<Integer, Integer>> orders = orderRepository.getOrders();
        if (orders.size() == 0) {
            System.out.println(NO_ORDERS_MSG);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter min date, please");
        DateTime before = new DateTime(scanner.nextLine());
        System.out.println("Enter max date, please");
        DateTime after = new DateTime(scanner.nextLine());
        for (Map.Entry<DateTime, Map<Integer, Integer>> outer_entry : orders.entrySet()) {
            if (outer_entry.getKey().getDateTime().isBefore(after.getDateTime()) &&
                    outer_entry.getKey().getDateTime().isAfter(before.getDateTime())) {
                System.out.println("order " + outer_entry.getKey());
                goodsService.showGoods(outer_entry.getValue());
            }
        }

    }

    /**
     * Shows order details of an order which is the nearest to the specified date
     */
    public void showNearestOrder() {
        TreeMap<DateTime, Map<Integer, Integer>> orders = (TreeMap<DateTime, Map<Integer, Integer>>) orderRepository.getOrders();
        if (orders.size() == 0) {
            System.out.println(NO_ORDERS_MSG);
            return;
        }
        System.out.println("Enter the nearest day, please");
        Scanner scanner = new Scanner(System.in);
        DateTime nearest = new DateTime(scanner.nextLine());
        Map.Entry<DateTime, Map<Integer, Integer>> lower = orders.lowerEntry(nearest);
        Map.Entry<DateTime, Map<Integer, Integer>> higher = orders.higherEntry(nearest);
        Map.Entry<DateTime, Map<Integer, Integer>> needed;
        if (Duration.between(lower.getKey().getDateTime(), nearest.getDateTime()).toMillis() <
                Duration.between(higher.getKey().getDateTime(), nearest.getDateTime()).toMillis()) {
            needed = lower;
        } else {
            needed = higher;
        }
        System.out.println("order " + needed.getKey());
        goodsService.showGoods(needed.getValue());

    }


}
