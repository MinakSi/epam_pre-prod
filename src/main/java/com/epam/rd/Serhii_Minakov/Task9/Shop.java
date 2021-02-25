package com.epam.rd.Serhii_Minakov.Task9;

import com.epam.rd.Serhii_Minakov.Task7.Output;
import com.epam.rd.Serhii_Minakov.Task9.command.CommandContainer;
import com.epam.rd.Serhii_Minakov.Task9.command.implementation.AddToCartCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.implementation.CreateNewGoodCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.implementation.CreateOrderCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.implementation.ShowCartCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.implementation.ShowGoodsCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.implementation.ShowHistoryCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.implementation.ShowNearestOrderCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.implementation.ShowOrdersInRangeCommand;
import com.epam.rd.Serhii_Minakov.Task9.input.types.ConsoleGoodsInput;
import com.epam.rd.Serhii_Minakov.Task9.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task9.input.types.RandomGoodsInput;
import com.epam.rd.Serhii_Minakov.Task9.repository.CartRepository;
import com.epam.rd.Serhii_Minakov.Task9.repository.GoodsRepository;
import com.epam.rd.Serhii_Minakov.Task9.repository.HistoryRepository;
import com.epam.rd.Serhii_Minakov.Task9.repository.OrderRepository;
import com.epam.rd.Serhii_Minakov.Task9.service.CartService;
import com.epam.rd.Serhii_Minakov.Task9.service.GoodsService;
import com.epam.rd.Serhii_Minakov.Task9.service.HistoryService;
import com.epam.rd.Serhii_Minakov.Task9.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Shop {

    private static final Logger logger = LogManager.getRootLogger();
    private final CommandContainer commandContainer;
    private CartService cart;
    private OrderService orders;
    private GoodsService goods;
    private HistoryService history;
    private final Map<String, GoodsInputType> inputTypes;
    private GoodsInputType goodsInputType;
    private boolean goodsRepositoryEmpty;
    private final Scanner scanner;
    private static final String CONSOLE_INPUT = "console";
    private static final String RANDOM_INPUT = "random";
    private static final String SHOW_PRODUCT_LIST = "goods";
    private static final String SHOW_CART = "cart";
    private static final String SHOW_HISTORY = "history";
    private static final String SHOW_ORDERS = "orders";
    private static final String ADD_TO_CART = "add";
    private static final String CREATE_ORDER = "order";
    private static final String SHOW_NEAREST = "nearest";
    private static final String NEW_GOOD = "new";
    private static final String QUIT = "quit";
    private static final String READ_FILE_ERR = "Sorry, there were some problems reading the file :(";
    private static final String ENTER_GOODS_MSG = "Enter some goods to warehouse";
    private static final String COMMAND_LIST_HEADER = "Command list:";
    private static final String ENTER_LOCALE_MSG = "Enter preferred locale: ru/en";
    private static final String UNKNOWN_COMMAND_ERR = "Unknown command above :(   Please, try again";
    private static final String ENTER_INPUT_TYPE_MSG = "What is type of input? console / random";
//    private static final String SOMETHING = "something";

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
            logger.error(READ_FILE_ERR);
            Output.printlnMessageToConsole(ENTER_GOODS_MSG);
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
        Output.printlnMessageToConsole(COMMAND_LIST_HEADER);
        commandContainer.getCommands().forEach((key, value) -> System.out.println(key));
        Output.printlnMessageToConsole(QUIT);
    }

    public void start() {
        this.goodsInputType = chooseGoodsInputType();
        goodsInputType.setLocale(chooseLocale());
        fillCommands();
        if (goodsRepositoryEmpty) {
            commandContainer.getCommandByKey(NEW_GOOD).execute();
        }
        printCommandList();
        generateMenu();
        saveGoods();
    }

    private Locale chooseLocale() {
        Output.printlnMessageToConsole(ENTER_LOCALE_MSG);
        return new Locale(scanner.nextLine());
    }

    private void generateMenu() {
        String action;
        while (!QUIT.equals(action = scanner.nextLine())) {
            if (commandContainer.getCommands().containsKey(action)) {
                commandContainer.getCommandByKey(action).execute();
            } else {
                logger.error(UNKNOWN_COMMAND_ERR);
            }
            printCommandList();
        }
    }

    private GoodsInputType chooseGoodsInputType() {
        String choice;
        boolean typeIsSet;
        GoodsInputType inputType;
        do {
            Output.printlnMessageToConsole(ENTER_INPUT_TYPE_MSG);
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
