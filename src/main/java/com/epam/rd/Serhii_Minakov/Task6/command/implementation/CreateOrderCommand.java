package com.epam.rd.Serhii_Minakov.Task6.command.implementation;

import com.epam.rd.Serhii_Minakov.Task6.command.Command;
import com.epam.rd.Serhii_Minakov.Task6.service.OrderService;

/**
 * This class executes creating new order
 */
public class CreateOrderCommand implements Command {
    private final OrderService orderService;

    public CreateOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        orderService.buy();
    }
}
