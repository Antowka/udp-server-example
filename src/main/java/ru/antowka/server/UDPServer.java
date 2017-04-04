package ru.antowka.server;

import ru.antowka.processor.aprs.AprsProcessor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP Server
 */
public class UDPServer {

    /**
     * Start UDP server
     *
     * @param listenPort
     * @throws IOException
     */
    public static void startUdpServer(Integer listenPort) throws IOException {

        DatagramSocket serverSocket = new DatagramSocket(listenPort);

        byte[] receiveData = new byte[1024];

        while(true) {

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("RECEIVED: " + sentence);
            AprsProcessor.sendDataToAprs(sentence);
        }
    }
}
