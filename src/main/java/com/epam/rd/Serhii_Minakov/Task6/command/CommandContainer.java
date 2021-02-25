package com.epam.rd.Serhii_Minakov.Task6.command;

import java.util.HashMap;
import java.util.Map;

/**
 * This class allows saving commands in the map.
 */
public class CommandContainer {
    private final Map<String, Command> commands;

    public CommandContainer() {
        commands = new HashMap<>();
    }

    public void addCommand(String key, Command command) {
        commands.put(key, command);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
