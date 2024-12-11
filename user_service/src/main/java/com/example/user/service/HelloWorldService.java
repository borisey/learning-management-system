package com.example.user.service;

import com.example.user.grpc.HelloWorldProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloWorldService extends com.example.user.grpc.GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloWorldProto.HelloRequest request, StreamObserver<HelloWorldProto.HelloReply> responseObserver) {

        String responseMessage = "Hello, dear " + request.getName();
        HelloWorldProto.HelloReply reply = HelloWorldProto.HelloReply.newBuilder()
                .setMessage(responseMessage)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
