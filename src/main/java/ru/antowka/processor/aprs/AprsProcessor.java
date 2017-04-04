package ru.antowka.processor.aprs;

import ru.antowka.client.TCPClient;

/**
 * Aprs client
 */
public class AprsProcessor {

    public static void sendDataToAprs(String data) {

        String[] commands = new String[2];
        commands[0] = "user UC6KFQ pass 22203";
        commands[1] = data;
        TCPClient.sendData("euro.aprs2.net", 14580, commands);
    }
}
