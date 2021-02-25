package com.epam.rd.Serhii_Minakov.Task4.command.implementation;

import com.epam.rd.Serhii_Minakov.Task4.command.Command;
import com.epam.rd.Serhii_Minakov.Task4.service.GoodsService;

public class ShowGoodsCommand implements Command {
    private final GoodsService goodsService;

    public ShowGoodsCommand(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void execute() {
        goodsService.showProducts();
    }
}
