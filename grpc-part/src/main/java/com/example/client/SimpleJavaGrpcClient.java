package com.example.client;

import com.example.stubs.ping.PingRequest;
import com.example.stubs.ping.PingResponse;
import com.example.stubs.ping.PingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import static com.example.server.SimpleServer.SERVER_ADDRESS;

public class SimpleJavaGrpcClient {
    private final ManagedChannel channel;
    private final PingServiceGrpc.PingServiceBlockingStub blockingStub;

    public SimpleJavaGrpcClient() {
        channel = ManagedChannelBuilder.forTarget(SERVER_ADDRESS) // localhost:50055
                .usePlaintext() // For simplicity, using insecure connection
                .build();

        blockingStub = PingServiceGrpc.newBlockingStub(channel);
    }

    public void sendMessage() {
        try {
            PingRequest request = PingRequest.newBuilder()
                    .setMessage("JAVA !_!_!_PING_!_!_!")
                    .build();

            PingResponse response = blockingStub.ping(request);
            System.out.println("Response received: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public void shutdown() {
        channel.shutdown();
    }

    public static void main(String[] args) {
        SimpleJavaGrpcClient client = new SimpleJavaGrpcClient();
        client.sendMessage();
        client.shutdown();
    }
}