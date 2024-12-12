package com.example.client.service;

import com.example.client.grpc.GreeterGrpc;
import com.example.client.grpc.HelloWorldProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloClientService {

    @GrpcClient("myGrpcService")
    private GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    public String sayHello(String name) {
        HelloWorldProto.HelloRequest request = HelloWorldProto.HelloRequest.newBuilder()
                .setName(name)
                .build();

        HelloWorldProto.HelloReply reply = greeterBlockingStub.sayHello(request);

        return reply.getMessage();
    }
}
