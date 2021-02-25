package com.epam.rd.Serhii_Minakov.Task9.part1.tcp;

import com.epam.rd.Serhii_Minakov.Task7.Output;
import com.epam.rd.Serhii_Minakov.Task9.StringWrapper;
import com.epam.rd.Serhii_Minakov.Task9.command.serverCommands.GetCountServerCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.serverCommands.GetItemServerCommand;
import com.epam.rd.Serhii_Minakov.Task9.command.serverCommands.ServerCommandContainer;
import com.epam.rd.Serhii_Minakov.Task9.models.Product;
import com.epam.rd.Serhii_Minakov.Task9.repository.GoodsRepository;
import com.epam.rd.Serhii_Minakov.Task9.service.GoodsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private static final int port = 3000;
    private static final Logger logger = LogManager.getRootLogger();
    private static BufferedReader socketReader;
    private static BufferedWriter socketWriter;
    private static ServerCommandContainer serverCommandContainer;
    private static GoodsService service;
    private static final String GET_COUNT_SERVER_COMMAND = "get count";
    private static final String IO_EXC_MSG = "an I/O error occurred when waiting for a connection";
    private static final String GET_ITEM_SERVER_COMMAND = "get item=\\d+";
    private static final String WRONG_COMMAND_MSG = "wrong command";
    private static final String WAITING_FOR_CONNECTION_MSG = "waiting for connection";
    private static final String CONNECTION_ESTABLISHED_MSG = "connection established";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                logger.info(WAITING_FOR_CONNECTION_MSG);
                Socket clientSocket = serverSocket.accept();
                logger.info(CONNECTION_ESTABLISHED_MSG);
                socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                socketWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                String clientMessage = socketReader.readLine();
                initializeGoodsService();
                initializeServerCommandContainer();
                StringWrapper respond = executeCommand(clientMessage);
                socketWriter.write(respond + "\n");
                socketWriter.flush();
            }
        } catch (IOException e) {
            logger.error(IO_EXC_MSG);
        }
    }

    private static void initializeGoodsService() {
        GoodsRepository repository = new GoodsRepository();
        service = new GoodsService(repository);
        service.addGood(new Product(1, "name1", 3.1, 4, "ff"));
        service.addGood(new Product(2, "name2", 3.2, 4, "ffa"));
        service.addGood(new Product(3, "name3", 3.3, 4, "ffb"));
    }

    private static void initializeServerCommandContainer() {
        serverCommandContainer = new ServerCommandContainer();
        serverCommandContainer.addCommand(GET_COUNT_SERVER_COMMAND, new GetCountServerCommand(service));
        serverCommandContainer.addCommand(GET_ITEM_SERVER_COMMAND, new GetItemServerCommand(service));
    }

    private static StringWrapper executeCommand(String clientMessage) {
        StringWrapper respond = new StringWrapper();
        if (serverCommandContainer.doesExist(clientMessage)) {
            serverCommandContainer.getCommandByKey(clientMessage).execute(clientMessage, respond);
        } else {
            Output.printlnMessageToConsole(WRONG_COMMAND_MSG);
            respond.setBody(WRONG_COMMAND_MSG);
        }
        return respond;
    }
}
