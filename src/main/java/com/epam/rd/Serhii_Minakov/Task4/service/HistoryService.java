package com.epam.rd.Serhii_Minakov.Task4.service;

import com.epam.rd.Serhii_Minakov.Task4.repository.HistoryRepository;

public class HistoryService {
    private final HistoryRepository historyRepository;
    private final GoodsService goodsService;
    public static final String EMPTY_HISTORY_MSG = "No goods were added";

    public HistoryService(HistoryRepository historyRepository, GoodsService goodsService) {
        this.historyRepository = historyRepository;
        this.goodsService = goodsService;
    }

    public void showHistory() {
        if (historyRepository.getHistory().size() > 0) {
            goodsService.showProducts(historyRepository.getHistory());
        } else {
            System.out.println(EMPTY_HISTORY_MSG);
        }
    }


    public boolean addHistory(int id, int amount) {
        return historyRepository.addHistory(id, amount);
    }
}
