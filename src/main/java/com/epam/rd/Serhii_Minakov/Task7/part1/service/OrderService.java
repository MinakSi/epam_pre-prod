package com.epam.rd.Serhii_Minakov.Task7.part1.service;

import com.epam.rd.Serhii_Minakov.Task7.Output;
import com.epam.rd.Serhii_Minakov.Task7.part1.DateTime;
import com.epam.rd.Serhii_Minakov.Task7.part1.repository.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final Logger logger = LogManager.getRootLogger();
    private static final String NO_ORDERS_MSG = "No orders were added";
    private static final String ENTER_DATE_TIME_MSG = "Enter date, time, please";
    private static final String ENTER_MIN_DATE_MSG = "Enter min date, please";
    private static final String ENTER_MAX_DATE_MSG = "Enter max date, please";
    private static final String ENTER_NEAREST_DAY_MSG = "Enter the nearest day, please";

    public OrderService(OrderRepository orderRepository, CartService cartService, GoodsService goodsService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.goodsService = goodsService;
    }

    /**
     * Creates a new order, adding it to the order repository
     */
    public void buy() {
        Output.printlnMessageToConsole(ENTER_DATE_TIME_MSG);
        Scanner scanner = new Scanner(System.in);
        String dateTime = scanner.nextLine();
        orderRepository.add(new DateTime(dateTime), cartService.getCart());
        logger.info("Order created. Total: " + cost() + " UAH");
        cartService.clear();
    }

    private double cost() {
        return cartService.getCart().entrySet().stream()
                .mapToDouble(x -> goodsService.get(x.getKey()).getPrice() * x.getValue())
                .sum();
    }

    /**
     * Shows orders that were created between the lower and higher limits
     */
    public void showOrdersInRange() {
        Map<DateTime, Map<Integer, Integer>> orders = orderRepository.getOrders();
        if (orders.isEmpty()) {
            Output.printlnMessageToConsole(NO_ORDERS_MSG);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        Output.printlnMessageToConsole(ENTER_MIN_DATE_MSG);
        DateTime before = new DateTime(scanner.nextLine());
        Output.printlnMessageToConsole(ENTER_MAX_DATE_MSG);
        DateTime after = new DateTime(scanner.nextLine());
        for (Map.Entry<DateTime, Map<Integer, Integer>> outer_entry : orders.entrySet()) {
            if (outer_entry.getKey().getDateTime().isBefore(after.getDateTime()) &&
                    outer_entry.getKey().getDateTime().isAfter(before.getDateTime())) {
                Output.printlnMessageToConsole("order " + outer_entry.getKey());
                goodsService.showGoods(outer_entry.getValue());
            }
        }
    }

    /**
     * Shows order details of an order which is the nearest to the specified date
     */
    public void showNearestOrder() {
        TreeMap<DateTime, Map<Integer, Integer>> orders = (TreeMap<DateTime, Map<Integer, Integer>>) orderRepository.getOrders();
        if (orders.isEmpty()) {
            Output.printlnMessageToConsole(NO_ORDERS_MSG);
            return;
        }
        Output.printlnMessageToConsole(ENTER_NEAREST_DAY_MSG);
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
        Output.printlnMessageToConsole("order " + needed.getKey());
        goodsService.showGoods(needed.getValue());
    }
}
