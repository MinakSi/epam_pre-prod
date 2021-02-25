package com.epam.rd.Serhii_Minakov.Task9.command.serverCommands;

import com.epam.rd.Serhii_Minakov.Task9.StringWrapper;
import com.epam.rd.Serhii_Minakov.Task9.models.Goods;
import com.epam.rd.Serhii_Minakov.Task9.service.GoodsService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetItemServerCommand implements ServerCommand {

    private static final String GET_ITEM_ID_REGEX = "(?<==)\\d+";
    private final GoodsService goodsService;
    private static final String NO_DATA_FOUND_MSG = "no goods found with the specified id";

    public GetItemServerCommand(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void execute(String request, StringWrapper respond) {
        Pattern itemIdPattern = Pattern.compile(GET_ITEM_ID_REGEX);
        Matcher matcher = itemIdPattern.matcher(request);
        if (!matcher.find()){
            respond.setBody(NO_DATA_FOUND_MSG);
            return;
        }
        int itemId = Integer.parseInt(matcher.group());
        Goods neededGood = goodsService.get(itemId);
        String outputString = neededGood.getName() + "|" + neededGood.getPrice();
        respond.setBody(outputString);
    }
}
