package com.epam.rd.Serhii_Minakov.Task4.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class HistoryRepository {
    private final Map<Integer, Integer> history;
    private static final int MAX_HISTORY_AMOUNT = 5;

    public HistoryRepository() {
        history = new LinkedHashMap<Integer, Integer>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > MAX_HISTORY_AMOUNT;
            }
        };
    }

    public boolean addHistory(int id, int amount) {
        history.put(id, amount);
        return true;
    }

    public Map<Integer, Integer> getHistory() {
        return history;
    }
}
