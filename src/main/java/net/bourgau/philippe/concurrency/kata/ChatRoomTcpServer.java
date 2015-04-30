package net.bourgau.philippe.concurrency.kata;

import java.net.ServerSocket;

public class ChatRoomTcpServer implements ChatRoom, AutoCloseable {

    private final ServerSocket serverSocket;

    public ChatRoomTcpServer(int port) throws Exception {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void enter(Broadcast client) throws Exception {

    }

    @Override
    public void broadcast(String message) {

    }

    @Override
    public void leave(Broadcast client) {

    }

    @Override
    public void close() throws Exception {
        serverSocket.close();
    }
}