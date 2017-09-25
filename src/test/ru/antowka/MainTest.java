package ru.antowka;

import org.junit.jupiter.api.Test;

import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by anton on 4/4/17.
 */
class MainTest {

    @Test
    void testUdpServer() throws Exception {

//        Thread t = new Thread(() -> {
//            try {
//                Main.main(new String[]{"7778"});
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        t.start();

//        Thread.sleep(1500);
        demoClientUDP();
//        t.interrupt();
    }

    private void demoClientUDP() {

        DatagramSocket clientSocket = null;
        try {
            clientSocket = new DatagramSocket();
            byte[] sendData = "UC6KFQ>APRS,TCPIP*,qAC,T2GREECE:!5619.08N/04403.27Eyop.Anton\n".getBytes(StandardCharsets.UTF_8);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("antowka.ru"), 7778);
            clientSocket.send(sendPacket);
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}