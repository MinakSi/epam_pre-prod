package com.epam.rd.Serhii_Minakov.Task6.service;

import com.epam.rd.Serhii_Minakov.Task6.repository.CartRepository;

import java.util.Map;
import java.util.Scanner;

/**
 * This class is created to manipulate with user's cart
 */
public class CartService {
    private final CartRepository cartRepository;
    private final GoodsService goodsService;
    private final HistoryService historyService;
    public static final String EMPTY_CART_MSG = "Your cart is empty :(";
    public static final String NO_SUCH_ELEMENT_MSG = "Sorry, there is no such element in the shop catalog :(";

    public CartService(CartRepository cartRepository, GoodsService goodsService, HistoryService historyService) {
        this.cartRepository = cartRepository;
        this.goodsService = goodsService;
        this.historyService = historyService;
    }

    /**
     * Shows goods if there are any in the cart,
     * outputs the specified message about empty cart if not
     */
    public void showCart() {
        if (cartRepository.getCart().size() > 0) {
            goodsService.showGoods(cartRepository.getCart());
        } else {
            System.out.println(EMPTY_CART_MSG);
        }
    }

    /**
     * Adds chosen goods to cart and history repositories
     * if there is no such good in the goods repository, writes the specified message
     */
    public void addToCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What product would you like to buy?");
        int prod_id = scanner.nextInt();
        System.out.println("How many?");
        int amount = scanner.nextInt();
        if (goodsService.existsById(prod_id)) {
            cartRepository.add(prod_id, amount);
            historyService.addHistory(prod_id, amount);
        } else {
            System.out.println(NO_SUCH_ELEMENT_MSG);
        }

    }

    public Map<Integer, Integer> getCart() {
        return cartRepository.getCart();
    }

    public boolean clear() {
        return cartRepository.clear();
    }


}
