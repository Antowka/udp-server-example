package ru.antowka.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Tcp client
 */
public class TCPClient {

    /**
     * Send data to tcp socket
     *
     * @param host
     * @param port
     * @param data
     */
    public static void sendData(String host, Integer port, String[] data) {

        try {

            Socket sock = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter out = new PrintWriter(sock.getOutputStream());

            for(String dataItem : data) {

                out.println(dataItem);
                out.flush();

                //read response
                System.out.println("Response on MSG:");
                System.out.println(in.readLine());

                try {
                    Thread.sleep(3000);                 //3 sec
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

            //close socket
            try {
                in.close();
                out.close();
                sock.close();
            } catch (IOException e) {
                System.out.println("Can't close socket!!!");
            }

        } catch (IOException e) {
            System.out.println("Socket is fail!!!");
        }
    }
}
