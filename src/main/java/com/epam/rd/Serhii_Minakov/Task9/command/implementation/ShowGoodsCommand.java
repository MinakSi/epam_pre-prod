package com.epam.rd.Serhii_Minakov.Task9.command.implementation;

import com.epam.rd.Serhii_Minakov.Task9.command.Command;
import com.epam.rd.Serhii_Minakov.Task9.service.GoodsService;

/**
 * This class executes showing goods that are in the goods warehouse (goods repository)
 */
public class ShowGoodsCommand implements Command {

    private final GoodsService goodsService;

    public ShowGoodsCommand(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void execute() {
        goodsService.showGoods();
    }
}
