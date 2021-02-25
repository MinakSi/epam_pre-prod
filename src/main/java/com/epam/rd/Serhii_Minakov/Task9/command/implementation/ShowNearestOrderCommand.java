package com.epam.rd.Serhii_Minakov.Task9.command.implementation;

import com.epam.rd.Serhii_Minakov.Task9.command.Command;
import com.epam.rd.Serhii_Minakov.Task9.service.OrderService;

/**
 * This class executes showing the nearest order
 */
public class ShowNearestOrderCommand implements Command {

    private final OrderService orderService;

    public ShowNearestOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        orderService.showNearestOrder();
    }
}
