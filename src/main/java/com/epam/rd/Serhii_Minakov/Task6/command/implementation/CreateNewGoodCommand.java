package com.epam.rd.Serhii_Minakov.Task6.command.implementation;

import com.epam.rd.Serhii_Minakov.Task6.command.Command;
import com.epam.rd.Serhii_Minakov.Task6.input.creators.Creator;
import com.epam.rd.Serhii_Minakov.Task6.input.creators.DepartureServiceCreator;
import com.epam.rd.Serhii_Minakov.Task6.input.creators.OnlineServiceCreator;
import com.epam.rd.Serhii_Minakov.Task6.input.creators.ProductCreator;
import com.epam.rd.Serhii_Minakov.Task6.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task6.service.GoodsService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *This class executes creating new Good
 * There is a map of Creators that can be executed by entering the specified string key
 * If entered string is unknown, there will be given one more attempt
 *  to enter the string (until the entered string will be one of known)
 *
 */
public class CreateNewGoodCommand implements Command {
    private final GoodsInputType inputType;
    private final Map<String, Creator> creators;
    private final GoodsService goodsService;
    public static final String PRODUCT = "product";
    public static final String ONLINE_SERVICE = "online service";
    public static final String DEPARTURE_SERVICE = "departure service";

    public CreateNewGoodCommand(GoodsInputType goodsInputType, GoodsService goodsService) {
        this.creators = new HashMap<>();
        this.goodsService = goodsService;
        this.inputType = goodsInputType;
        fillCreators();
    }

    private void fillCreators() {
        creators.put(PRODUCT, new ProductCreator(inputType));
        creators.put(ONLINE_SERVICE, new OnlineServiceCreator(inputType));
        creators.put(DEPARTURE_SERVICE, new DepartureServiceCreator(inputType));
    }

    private void printCommandList() {
        System.out.println("Command list:");
        for (Map.Entry<String, Creator> entry : creators.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    private void createNewGood() {
        Scanner scanner = new Scanner(System.in);
        String action;
        boolean wrongInput;
        do {
            action = scanner.nextLine();
            if (creators.containsKey(action)) {
                goodsService.addGood(creators.get(action).create());
                wrongInput = false;
            } else {
                System.out.println("Unknown command above :(   Please, try again");
                wrongInput = true;
                printCommandList();
            }
        } while (wrongInput);
    }

    @Override
    public void execute() {
        printCommandList();
        createNewGood();
    }
}
