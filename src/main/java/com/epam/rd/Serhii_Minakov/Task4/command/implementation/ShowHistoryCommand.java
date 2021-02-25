package com.epam.rd.Serhii_Minakov.Task4.command.implementation;

import com.epam.rd.Serhii_Minakov.Task4.command.Command;
import com.epam.rd.Serhii_Minakov.Task4.service.HistoryService;

public class ShowHistoryCommand implements Command {
    private final HistoryService historyService;

    public ShowHistoryCommand(HistoryService cartService) {
        this.historyService = cartService;
    }

    @Override
    public void execute() {
        historyService.showHistory();
    }
}
