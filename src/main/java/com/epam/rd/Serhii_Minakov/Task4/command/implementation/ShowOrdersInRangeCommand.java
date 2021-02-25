package com.epam.rd.Serhii_Minakov.Task4.command.implementation;

import com.epam.rd.Serhii_Minakov.Task4.command.Command;
import com.epam.rd.Serhii_Minakov.Task4.service.OrderService;

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
