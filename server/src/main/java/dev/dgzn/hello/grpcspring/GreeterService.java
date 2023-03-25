package dev.dgzn.hello.grpcspring;

import dev.dgzn.hello.grpc.GreeterGrpc;
import dev.dgzn.hello.grpc.HelloRequest;
import dev.dgzn.hello.grpc.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHelloOnce(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.hasName() ? request.getName() : "World";
        responseObserver.onNext(HelloResponse.newBuilder().setMessage("Hello "+name+"!").build());
        responseObserver.onCompleted();
    }
}
