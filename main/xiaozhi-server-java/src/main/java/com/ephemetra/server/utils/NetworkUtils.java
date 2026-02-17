package com.ephemetra.server.utils;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class NetworkUtils {
    public static String getLocalIp() {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByAddress(new byte[]{8, 8, 8, 8}), 80);
            String ip = socket.getLocalAddress().getHostAddress();
            return (ip == null || ip.equals("0.0.0.0")) ? "127.0.0.1" : ip;
        } catch (Exception e) {
            return "127.0.0.1";
        }
    }
}