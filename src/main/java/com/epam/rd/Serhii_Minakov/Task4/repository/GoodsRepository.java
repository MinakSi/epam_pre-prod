package com.epam.rd.Serhii_Minakov.Task4.repository;

import com.epam.rd.Serhii_Minakov.Task4.models.Goods;
import com.epam.rd.Serhii_Minakov.Task4.models.Product;

import java.util.ArrayList;
import java.util.List;


public class GoodsRepository {
    private final List<Goods> goods;

    public GoodsRepository() {
        goods = new ArrayList<>();
    }

    public boolean add(Product product) {
        goods.add(product);
        return true;

    }

    public Goods get(int id) {
        for (Goods p : goods) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public boolean existsById(int id) {
        for (Goods p : goods) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
