package com.epam.rd.Serhii_Minakov.Task6.service;

import com.epam.rd.Serhii_Minakov.Task6.models.Goods;
import com.epam.rd.Serhii_Minakov.Task6.models.Product;
import com.epam.rd.Serhii_Minakov.Task6.repository.GoodsRepository;

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
            for (Goods good : goodsRepository.getGoods()) {
                System.out.println(good);
            }
        } else {
            System.out.println(EMPTY_PLIST_MSG);
        }
    }

    /**
     * Outputs to the console the information about goods stored in the map
     * @param map - goods information of which is needed to be written
     */
    public void showGoods(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("id = " + entry.getKey() + "\t" + goodsRepository.get(entry.getKey()));
        }
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
