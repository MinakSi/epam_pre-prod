package com.epam.rd.Serhii_Minakov.Task9.command.implementation;

import com.epam.rd.Serhii_Minakov.Task9.command.Command;
import com.epam.rd.Serhii_Minakov.Task9.service.HistoryService;

/**
 * This class executes showing history
 */
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
