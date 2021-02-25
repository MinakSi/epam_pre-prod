package com.epam.rd.Serhii_Minakov.Task7.part1.command.implementation;

import com.epam.rd.Serhii_Minakov.Task7.part1.command.Command;
import com.epam.rd.Serhii_Minakov.Task7.part1.service.OrderService;

/**
 * This class executes showing orders in date range
 */
public class ShowOrdersInRangeCommand implements Command {

    private final OrderService orderService;

    public ShowOrdersInRangeCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        orderService.showOrdersInRange();
    }
}
