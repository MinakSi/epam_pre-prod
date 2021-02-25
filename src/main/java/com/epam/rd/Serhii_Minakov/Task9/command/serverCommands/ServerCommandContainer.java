package com.epam.rd.Serhii_Minakov.Task9.command.serverCommands;

import java.util.HashMap;
import java.util.Map;

/**
 * This class allows saving commands in the map.
 */
public class ServerCommandContainer {

    private final Map<String, ServerCommand> commands;

    public ServerCommandContainer() {
        commands = new HashMap<>();
    }

    public void addCommand(String key, ServerCommand command) {
        commands.put(key, command);
    }

    public Map<String, ServerCommand> getCommands() {
        return commands;
    }

    public ServerCommand getCommandByKey(String key) {
        return commands.entrySet()
                .stream()
                .filter(x->key.matches(x.getKey()))
                .findFirst()
                .get()
                .getValue();
    }

    public boolean doesExist(String key) {
        return commands.entrySet()
                .stream()
                .anyMatch(x -> key.matches(x.getKey()));
    }
}
