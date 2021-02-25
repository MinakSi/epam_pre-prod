package com.epam.rd.Serhii_Minakov.Task9.command.serverCommands;

import com.epam.rd.Serhii_Minakov.Task9.StringWrapper;

@FunctionalInterface
public interface ServerCommand {

    void execute(String request, StringWrapper respond);
}
