package com.epam.rd.Serhii_Minakov.Task9.part1.tcp;

import com.epam.rd.Serhii_Minakov.Task7.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    private static final Logger logger = LogManager.getRootLogger();
    private static final int port = 3000;
    private static BufferedWriter socketWriter;
    private static BufferedReader socketReader;
    private static BufferedReader consoleReader;
    private static final String HOST = "localhost";
    private static final String ENTER_MESSAGE_MSG = "enter message:";
    private static final String SERVER_SAID_MSG = "Server said: ";
    private static final String IO_EXC_MSG = "an I/O error occurred when waiting for a connection";

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket(HOST, port);
            consoleReader = new BufferedReader(new InputStreamReader(System.in));
            socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            socketWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            Output.printlnMessageToConsole(ENTER_MESSAGE_MSG);
            String clientMessage = consoleReader.readLine();
            socketWriter.write(clientMessage + "\n");
            socketWriter.flush();
            String serverMessage = socketReader.readLine();
            System.out.println(SERVER_SAID_MSG + serverMessage);
        } catch (IOException e) {
            logger.error(IO_EXC_MSG);
        }
    }
}
