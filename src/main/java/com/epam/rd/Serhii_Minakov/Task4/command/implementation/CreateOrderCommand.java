package com.epam.rd.Serhii_Minakov.Task4.command.implementation;

import com.epam.rd.Serhii_Minakov.Task4.command.Command;
import com.epam.rd.Serhii_Minakov.Task4.service.OrderService;

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
