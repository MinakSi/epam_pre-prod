package com.epam.rd.Serhii_Minakov.Task9.service;

import com.epam.rd.Serhii_Minakov.Task9.repository.HistoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *This class is created to manipulate with history
 */
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final GoodsService goodsService;
    private final Logger logger = LogManager.getRootLogger();
    private static final String EMPTY_HISTORY_MSG = "No goods were added";

    public HistoryService(HistoryRepository historyRepository, GoodsService goodsService) {
        this.historyRepository = historyRepository;
        this.goodsService = goodsService;
    }

    /**
     * Shows goods which are in the history repository
     * If there is no goods there, shows the specified message
     */
    public void showHistory() {
        if (historyRepository.getHistory().size() > 0) {
            goodsService.showGoods(historyRepository.getHistory());
        } else {
            logger.error(EMPTY_HISTORY_MSG);
        }
    }

    /**
     * Adds good and amount to history repository by its id
     * @param id - id of good to be stored
     * @param amount - amount of goods
     * @return true if success
     */
    public boolean addHistory(int id, int amount) {
        return historyRepository.addHistory(id, amount);
    }
}
