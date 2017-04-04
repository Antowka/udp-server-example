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

        new Thread(() -> {
            try {
                Main.main(new String[]{"7779"});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1500);

        demoClientUDP();
    }

    private void demoClientUDP() throws IOException {

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = "UC6KFQ>APRS,TCPIP*,qAC,T2NL:!5619.08N/04403.22Eyop.Anton (UC6KFQ/3) 145.500Mhz/433.500Mhz\n".getBytes(StandardCharsets.UTF_8);
        byte[] receiveData = new byte[1024];
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7779);
        clientSocket.send(sendPacket);
//        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//        clientSocket.receive(receivePacket);
//        String modifiedSentence = new String(receivePacket.getData());
//        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}