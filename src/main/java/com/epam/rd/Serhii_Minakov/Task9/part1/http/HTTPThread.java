package com.epam.rd.Serhii_Minakov.Task9.part1.http;

import com.epam.rd.Serhii_Minakov.Task9.service.GoodsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HTTPThread implements Runnable {

    private static final Logger logger = LogManager.getRootLogger();
    private static BufferedReader socketReader;
    private static BufferedWriter socketWriter;
    private static GoodsService service;
    private static final String IO_EXC_MSG = "an I/O error occurred when waiting for a connection";
    private final Socket clientSocket;
    String clientMsg;

    public HTTPThread(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            socketWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//            String clientMessage = socketReader.readLine();
            readInputHeaders();
            writeResponse("----->"+clientMsg+"<-----");
//            writeResponse("<html><body><h1>" + clientMessage + "</h1></body></html>");
        } catch (IOException e) {
            logger.error(IO_EXC_MSG);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                logger.error(IO_EXC_MSG);
            }
        }
    }

    private void writeResponse(String s) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + s;
        socketWriter.write(result + "\n");
        socketWriter.flush();
    }

    private void readInputHeaders() throws IOException {
        while (true) {
            clientMsg = socketReader.readLine();
            if (clientMsg == null || clientMsg.trim().length() == 0) {
                break;
            }
        }
    }
}
