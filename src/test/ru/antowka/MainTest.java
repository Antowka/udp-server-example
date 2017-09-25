package ru.antowka;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * Created by anton on 4/4/17.
 */
class MainTest {

    @Test
    void testUdpServer() throws Exception {

        Thread t = new Thread(() -> {
            try {
                Main.main(new String[]{"7763"});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();

        Thread.sleep(1500);
        demoClientUDP();
        t.interrupt();
    }

    private void demoClientUDP() throws IOException {

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = "UC6KFQ>APRS,TCPIP*,qAC,T2GREECE:!5619.08N/04403.27Eyop.Anton\n".getBytes(StandardCharsets.UTF_8);
        byte[] receiveData = new byte[1024];
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7763);
        clientSocket.send(sendPacket);
//        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//        clientSocket.receive(receivePacket);
//        String modifiedSentence = new String(receivePacket.getData());
//        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}