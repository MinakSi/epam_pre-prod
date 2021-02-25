package com.epam.rd.Serhii_Minakov.Task6;

import com.epam.rd.Serhii_Minakov.Task6.command.Command;
import com.epam.rd.Serhii_Minakov.Task6.command.CommandContainer;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.AddToCartCommand;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.CreateOrderCommand;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.ShowCartCommand;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.ShowGoodsCommand;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.ShowHistoryCommand;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.ShowNearestOrderCommand;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.ShowOrdersInRangeCommand;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.CreateNewGoodCommand;
import com.epam.rd.Serhii_Minakov.Task6.input.types.ConsoleGoodsInput;
import com.epam.rd.Serhii_Minakov.Task6.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task6.input.types.RandomGoodsInput;
import com.epam.rd.Serhii_Minakov.Task6.repository.CartRepository;
import com.epam.rd.Serhii_Minakov.Task6.repository.GoodsRepository;
import com.epam.rd.Serhii_Minakov.Task6.repository.HistoryRepository;
import com.epam.rd.Serhii_Minakov.Task6.repository.OrderRepository;
import com.epam.rd.Serhii_Minakov.Task6.service.CartService;
import com.epam.rd.Serhii_Minakov.Task6.service.GoodsService;
import com.epam.rd.Serhii_Minakov.Task6.service.HistoryService;
import com.epam.rd.Serhii_Minakov.Task6.service.OrderService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop {
    private final CommandContainer commandContainer;
    private CartService cart;
    private OrderService orders;
    private GoodsService goods;
    private HistoryService history;
    private final Map<String, GoodsInputType> inputTypes;
    private GoodsInputType goodsInputType;
    private boolean goodsRepositoryEmpty;
    private final Scanner scanner;
    public static final String CONSOLE_INPUT = "console";
    public static final String RANDOM_INPUT = "random";
    private static final String SHOW_PRODUCT_LIST = "goods";
    private static final String SHOW_CART = "cart";
    private static final String SHOW_HISTORY = "history";
    private static final String SHOW_ORDERS = "orders";
    private static final String ADD_TO_CART = "add";
    public static final String CREATE_ORDER = "order";
    public static final String SHOW_NEAREST = "nearest";
    public static final String NEW_GOOD = "new";
    private static final String QUIT = "quit";

    public Shop() {
        this.scanner = new Scanner(System.in);
        this.commandContainer = new CommandContainer();
        this.inputTypes = new HashMap<>();
        fillTypes();
        initializeServices();
    }

    private void initializeServices() {
        GoodsRepository goodsRepository = readGoods();
        CartRepository cartRepository = new CartRepository();
        OrderRepository orderRepository = new OrderRepository();
        HistoryRepository historyRepository = new HistoryRepository();
        this.goodsRepositoryEmpty = goodsRepository.getGoods().isEmpty();
        this.goods = new GoodsService(goodsRepository);
        this.history = new HistoryService(historyRepository, goods);
        this.cart = new CartService(cartRepository, goods, history);
        this.orders = new OrderService(orderRepository, cart, goods);
    }

    private GoodsRepository readGoods() {
        try {
            return GoodsSaver.readAll();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Sorry, there were some problems reading the file :(");
            System.out.println("Enter some goods to warehouse");
            return new GoodsRepository();
        }
    }

    private void fillTypes() {
        this.inputTypes.put(CONSOLE_INPUT, new ConsoleGoodsInput());
        this.inputTypes.put(RANDOM_INPUT, new RandomGoodsInput());
    }

    private void fillCommands() {
        commandContainer.addCommand(SHOW_PRODUCT_LIST, new ShowGoodsCommand(goods));
        commandContainer.addCommand(SHOW_CART, new ShowCartCommand(cart));
        commandContainer.addCommand(SHOW_HISTORY, new ShowHistoryCommand(history));
        commandContainer.addCommand(ADD_TO_CART, new AddToCartCommand(cart));
        commandContainer.addCommand(CREATE_ORDER, new CreateOrderCommand(orders));
        commandContainer.addCommand(SHOW_ORDERS, new ShowOrdersInRangeCommand(orders));
        commandContainer.addCommand(SHOW_NEAREST, new ShowNearestOrderCommand(orders));
        commandContainer.addCommand(NEW_GOOD, new CreateNewGoodCommand(goodsInputType, goods));
    }

    private void printCommandList() {
        System.out.println("Command list:");
        for (Map.Entry<String, Command> entry : commandContainer.getCommands().entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println(QUIT);
    }

    public void start() {
        this.goodsInputType = chooseGoodsInputType();
        fillCommands();
        if (goodsRepositoryEmpty) {
            commandContainer.getCommands().get(NEW_GOOD).execute();
        }
        printCommandList();
        generateMenu();
        saveGoods();
    }

    private void generateMenu() {
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

    private GoodsInputType chooseGoodsInputType() {
        String choice;
        boolean typeIsSet;
        GoodsInputType inputType;
        do {
            System.out.println(" What is type of input? console / random");
            choice = scanner.nextLine();
            inputType = inputTypes.get(choice);
            typeIsSet = inputType != null;
        } while (!typeIsSet);
        return inputType;
    }

    private void saveGoods() {
        try {
            GoodsSaver.saveAll(goods.getGoodsRepository());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.start();
    }
}
