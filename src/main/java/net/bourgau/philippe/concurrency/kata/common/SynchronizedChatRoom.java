package net.bourgau.philippe.concurrency.kata.common;

import java.util.concurrent.TimeUnit;

public class SynchronizedChatRoom implements ChatRoom {

    private final ChatRoom realChatRoom;

    public SynchronizedChatRoom(ChatRoom realChatRoom) {
        this.realChatRoom = realChatRoom;
    }

    @Override
    public synchronized void enter(Output client, String pseudo) {
        realChatRoom.enter(client, pseudo);
    }

    @Override
    public synchronized void broadcast(Output client, String message) {
        realChatRoom.broadcast(client, message);
    }

    @Override
    public synchronized void leave(Output client) {
        realChatRoom.leave(client);
    }

    @Override
    public boolean waitForAbandon(long count, TimeUnit timeUnit) throws InterruptedException {
        return realChatRoom.waitForAbandon(count, timeUnit);
    }
}
