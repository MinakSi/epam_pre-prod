package com.epam.rd.Serhii_Minakov.Task4;

import com.epam.rd.Serhii_Minakov.Task4.command.Command;
import com.epam.rd.Serhii_Minakov.Task4.command.CommandContainer;
import com.epam.rd.Serhii_Minakov.Task4.command.implementation.*;
import com.epam.rd.Serhii_Minakov.Task4.models.Product;
import com.epam.rd.Serhii_Minakov.Task4.repository.CartRepository;
import com.epam.rd.Serhii_Minakov.Task4.repository.HistoryRepository;
import com.epam.rd.Serhii_Minakov.Task4.repository.OrderRepository;
import com.epam.rd.Serhii_Minakov.Task4.repository.GoodsRepository;
import com.epam.rd.Serhii_Minakov.Task4.service.CartService;
import com.epam.rd.Serhii_Minakov.Task4.service.HistoryService;
import com.epam.rd.Serhii_Minakov.Task4.service.OrderService;
import com.epam.rd.Serhii_Minakov.Task4.service.GoodsService;

import java.util.Map;
import java.util.Scanner;

public class Shop {
    private final CommandContainer commandContainer;
    private final CartService cart;
    private final OrderService orders;
    private final GoodsService goods;
    private final HistoryService history;
    private static final String SHOW_PRODUCT_LIST = "goods";
    private static final String SHOW_CART = "cart";
    private static final String SHOW_HISTORY = "history";
    private static final String SHOW_ORDERS = "orders";
    private static final String ADD_TO_CART = "add";
    public static final String CREATE_ORDER = "order";
    public static final String SHOW_NEAREST = "nearest";
    private static final String QUIT = "quit";

    public Shop() {
        this.commandContainer = new CommandContainer();
        CartRepository cartRepository = new CartRepository();
        GoodsRepository goodsRepository = new GoodsRepository();
        OrderRepository orderRepository = new OrderRepository();
        HistoryRepository historyRepository = new HistoryRepository();
        this.goods = new GoodsService(goodsRepository);
        this.history = new HistoryService(historyRepository, goods);
        this.cart = new CartService(cartRepository, goods, history);
        this.orders = new OrderService(orderRepository, cart, goods);
        fillCommands();
        fillStorage();
    }

    private void fillCommands() {
        commandContainer.addCommand(SHOW_PRODUCT_LIST, new ShowGoodsCommand(goods));
        commandContainer.addCommand(SHOW_CART, new ShowCartCommand(cart));
        commandContainer.addCommand(SHOW_HISTORY, new ShowHistoryCommand(history));
        commandContainer.addCommand(ADD_TO_CART, new AddToCartCommand(cart));
        commandContainer.addCommand(CREATE_ORDER, new CreateOrderCommand(orders));
        commandContainer.addCommand(SHOW_ORDERS, new ShowOrdersInRangeCommand(orders));
        commandContainer.addCommand(SHOW_NEAREST, new ShowNearestOrderCommand(orders));
    }

    private void fillStorage() {
        goods.addProduct(new Product(1, "one", 111, 99));
        goods.addProduct(new Product(2, "two", 222, 99));
        goods.addProduct(new Product(3, "three", 333, 99));
        goods.addProduct(new Product(4, "four", 444, 99));
        goods.addProduct(new Product(5, "five", 555, 99));
        goods.addProduct(new Product(6, "six", 666, 99));
        goods.addProduct(new Product(7, "seven", 777, 99));
        goods.addProduct(new Product(8, "eight", 888, 99));
        goods.addProduct(new Product(9, "nine", 999, 99));
    }

    private void printCommandList() {
        System.out.println("Command list:");
        for (Map.Entry<String, Command> entry : commandContainer.getCommands().entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println(QUIT);
    }

    public void start() {
        System.out.println("Welcome!");
        printCommandList();
        Scanner scanner = new Scanner(System.in);
        String action;
        while (!QUIT.equals(action = scanner.nextLine())) {
            if (commandContainer.getCommands().containsKey(action)) {
                commandContainer.getCommands().get(action).execute();
            } else {
                System.out.println("Unknown command above :(   Please, try again");
            }
            printCommandList();
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.start();
    }
}
