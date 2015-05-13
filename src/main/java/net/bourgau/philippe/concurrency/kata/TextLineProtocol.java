package net.bourgau.philippe.concurrency.kata;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TextLineProtocol implements AutoCloseable {
    private final Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public TextLineProtocol(Socket socket) throws Exception {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void writeMessage(String message) throws Exception {
        writer.write(message + "\n");
        writer.flush();
    }

    public String readMessage() throws Exception {
        return reader.readLine();
    }

    @Override
    public void close() {
        IOUtils.closeQuietly(socket);
    }
}