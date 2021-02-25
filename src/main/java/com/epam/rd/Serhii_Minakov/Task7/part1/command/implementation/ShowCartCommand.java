package com.epam.rd.Serhii_Minakov.Task7.part1.command.implementation;

import com.epam.rd.Serhii_Minakov.Task7.part1.command.Command;
import com.epam.rd.Serhii_Minakov.Task7.part1.service.CartService;

/**
 * This class executes showing cart
 */
public class ShowCartCommand implements Command {

    private final CartService cartService;

    public ShowCartCommand(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        cartService.showCart();
    }
}
