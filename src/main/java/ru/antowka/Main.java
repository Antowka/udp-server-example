package ru.antowka;

import ru.antowka.server.UDPServer;

public class Main {

    public static void main(String args[]) throws Exception {

        int port = 7779;
        if (args.length != 0) {
            port = Integer.valueOf(args[0]);
        }

        UDPServer.startUdpServer(port);
    }
}
