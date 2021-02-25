package com.epam.rd.Serhii_Minakov.Task6.repository;

import com.epam.rd.Serhii_Minakov.Task6.models.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is created to store goods which are in a warehouse
 */
public class GoodsRepository {
    private final List<Goods> goods;

    public GoodsRepository() {
        goods = new ArrayList<>();
    }

    public GoodsRepository(List<Goods> goods) {
        this.goods = goods;
    }

    public boolean add(Goods good) {
        goods.add(good);
        return true;

    }

    /**
     * @param id id of good needed to be returned
     * @return a good if a good with this id exists, null if not
     */
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

    /**
     * This method checks if there is a good with the specified
     * id exists in the storage
     *
     * @param id id of good needed to be checked
     * @return true if exists, false if not
     */
    public boolean existsById(int id) {
        for (Goods p : goods) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }


}
