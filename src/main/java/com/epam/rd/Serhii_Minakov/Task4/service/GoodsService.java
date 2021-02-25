package com.epam.rd.Serhii_Minakov.Task4.service;

import com.epam.rd.Serhii_Minakov.Task4.models.Goods;
import com.epam.rd.Serhii_Minakov.Task4.models.Product;
import com.epam.rd.Serhii_Minakov.Task4.repository.GoodsRepository;

import java.util.Map;

public class GoodsService {
    private final GoodsRepository goodsRepository;
    private static final String EMPTY_PLIST_MSG = "Sorry, there is no goods yet :(";

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public void showProducts() {
        if (goodsRepository.getGoods().size() > 0) {
            for (Goods good : goodsRepository.getGoods()) {
                System.out.println(good);
            }
        } else {
            System.out.println(EMPTY_PLIST_MSG);
        }
    }
    public void showProducts(Map<Integer, Integer> map){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("id = "+entry.getKey()+"\t" + goodsRepository.get(entry.getKey()));
        }
    }
    public Goods get(int id) {
        return goodsRepository.get(id);
    }

    public boolean addProduct(Product product) {
        return goodsRepository.add(product);
    }

    public boolean existsById(int id){
        return goodsRepository.existsById(id);
    }

}
