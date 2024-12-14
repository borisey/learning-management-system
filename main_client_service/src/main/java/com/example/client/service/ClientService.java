package com.example.client.service;

import com.example.client.grpc.GreeterGrpc;
import com.example.client.grpc.HelloWorldProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    public ClientService() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("userService", 9090)
                .usePlaintext()
                .build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public String saveUser(String name) {
        HelloWorldProto.SaveUserRequest request = HelloWorldProto.SaveUserRequest.newBuilder().setName(name).build();
        return blockingStub.saveUser(request).getMessage();
    }

    public String getUsers() {
        HelloWorldProto.GetUsersRequest request = HelloWorldProto.GetUsersRequest.newBuilder().build();
        return blockingStub.getUsers(request).getMessage();
    }
}
