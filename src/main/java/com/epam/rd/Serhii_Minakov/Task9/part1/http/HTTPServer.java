package com.epam.rd.Serhii_Minakov.Task9.part1.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {

    private static final int port = 4000;
    private static final Logger logger = LogManager.getRootLogger();
    private static final String WAITING_FOR_CONNECTION_MSG = "HTTP waiting for connection";
    private static final String CONNECTION_ESTABLISHED_MSG = "HTTP connection established";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            logger.info(WAITING_FOR_CONNECTION_MSG);
            Socket clientSocket = serverSocket.accept();
            logger.info(CONNECTION_ESTABLISHED_MSG);
            new Thread(new HTTPThread(clientSocket)).start();
        }
    }

    /*private static void initializeGoodsService() {
        GoodsRepository repository = new GoodsRepository();
        service = new GoodsService(repository);
        service.addGood(new Product(1, "name1", 3.1, 4, "ff"));
        service.addGood(new Product(2, "name2", 3.2, 4, "ffa"));
        service.addGood(new Product(3, "name3", 3.3, 4, "ffb"));
    }*/

}
