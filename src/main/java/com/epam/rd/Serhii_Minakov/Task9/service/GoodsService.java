package com.epam.rd.Serhii_Minakov.Task9.service;

import com.epam.rd.Serhii_Minakov.Task7.Output;
import com.epam.rd.Serhii_Minakov.Task9.models.Goods;
import com.epam.rd.Serhii_Minakov.Task9.repository.GoodsRepository;

import java.util.Map;

/**
 * This class is created to manipulate with goods
 */
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private static final String EMPTY_PLIST_MSG = "Sorry, there is no goods yet :(";

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    /**
     * Outputs to the console the information about goods
     * which are in the goods repository
     */
    public void showGoods() {
        if (goodsRepository.getGoods().size() > 0) {
            goodsRepository.getGoods().forEach(Output::printlnMessageToConsole);
        } else {
            Output.printlnMessageToConsole(EMPTY_PLIST_MSG);
        }
    }

    /**
     * Outputs to the console the information about goods stored in the map
     *
     * @param map - goods information of which is needed to be written
     */
    public void showGoods(Map<Integer, Integer> map) {
        map.forEach((key, value) -> System.out.println("id = " + key + "\t" + goodsRepository.get(key)));
    }

    public Goods get(int id) {
        return goodsRepository.get(id);
    }

    public GoodsRepository getGoodsRepository() {
        return goodsRepository;
    }

    public boolean addGood(Goods good) {
        return goodsRepository.add(good);
    }

    public boolean existsById(int id) {
        return goodsRepository.existsById(id);
    }
}
