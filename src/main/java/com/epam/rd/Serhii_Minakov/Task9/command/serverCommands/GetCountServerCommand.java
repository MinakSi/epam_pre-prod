package com.epam.rd.Serhii_Minakov.Task9.command.serverCommands;

import com.epam.rd.Serhii_Minakov.Task9.StringWrapper;
import com.epam.rd.Serhii_Minakov.Task9.service.GoodsService;

public class GetCountServerCommand implements ServerCommand {

    private final GoodsService goodsService;

    public GetCountServerCommand(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void execute(String request, StringWrapper respond) {
        respond.setBody(String.valueOf(goodsService.getGoodsRepository().getGoods().size()));
    }
}
