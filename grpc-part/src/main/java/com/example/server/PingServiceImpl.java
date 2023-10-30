package com.example.server;

import com.example.stubs.ping.PingRequest;
import com.example.stubs.ping.PingResponse;
import com.example.stubs.ping.PingServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

/**
 * Actual SimpleServer processor for specific
 */
public class PingServiceImpl extends PingServiceGrpc.PingServiceImplBase {
    private final Logger LOGGER = Logger.getLogger(PingServiceImpl.class.getName());

    public static final String TEXT = "!_!_!_PONG_!_!_!";

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        String message = request.getMessage();
        LOGGER.info(message);

        PingResponse pingResponse = PingResponse.newBuilder()
                .setMessage(TEXT)
                .build();

        responseObserver.onNext(pingResponse);
        responseObserver.onCompleted();
    }
}
