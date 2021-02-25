package com.epam.rd.Serhii_Minakov.Task4.command.implementation;

import com.epam.rd.Serhii_Minakov.Task4.command.Command;
import com.epam.rd.Serhii_Minakov.Task4.service.CartService;

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
