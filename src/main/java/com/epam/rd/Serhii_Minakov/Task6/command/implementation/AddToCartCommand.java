package com.epam.rd.Serhii_Minakov.Task6.command.implementation;

import com.epam.rd.Serhii_Minakov.Task6.command.Command;
import com.epam.rd.Serhii_Minakov.Task6.service.CartService;

/**
 * This class executes adding to cart
 */
public class AddToCartCommand implements Command {
    private final CartService cartService;

    public AddToCartCommand(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        cartService.addToCart();
    }
}
