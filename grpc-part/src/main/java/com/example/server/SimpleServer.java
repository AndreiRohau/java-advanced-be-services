package com.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleServer {
    private static final Logger logger = Logger.getLogger(SimpleServer.class.getName());

    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 50055;
    public static final String SERVER_ADDRESS = SERVER_IP + ":" + SERVER_PORT;

    private Server server;

    public void startServer(){
        try {
            server = ServerBuilder.forPort(SERVER_PORT)
                    .addService(new PingServiceImpl())
                    .build()
                    .start();
            logger.info("SimpleServer started on port: " + SERVER_PORT);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                logger.info("Clean server shutdown in case JVM was shutdown");
                try {
                    SimpleServer.this.stopServer();
                } catch (InterruptedException exception) {
                    logger.log(Level.SEVERE, "Server shutdown interrupted", exception);
                }
            }));
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "Server did not start", exception);
        }
    }

    public void stopServer() throws InterruptedException {
        if(server!=null){
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if(server!=null){
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleServer orderServer = new SimpleServer();
        orderServer.startServer();
        orderServer.blockUntilShutdown();

    }
}
