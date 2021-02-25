package com.epam.rd.Serhii_Minakov.Task7.part1.command.implementation;

import com.epam.rd.Serhii_Minakov.Task7.part1.command.Command;
import com.epam.rd.Serhii_Minakov.Task7.part1.service.OrderService;

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
