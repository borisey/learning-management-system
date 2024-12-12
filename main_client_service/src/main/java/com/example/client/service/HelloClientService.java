package com.example.client.service;

import com.example.client.grpc.GreeterGrpc;
import com.example.client.grpc.HelloWorldProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class HelloClientService {
    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    public HelloClientService() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("userService", 9090)
                .usePlaintext()
                .build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public String sayHello(String name) {
        HelloWorldProto.HelloRequest request = HelloWorldProto.HelloRequest.newBuilder().setName(name).build();
        return blockingStub.sayHello(request).getMessage();
    }
}
