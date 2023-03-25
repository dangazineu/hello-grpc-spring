package dev.dgzn.hello.grpcspring;

import dev.dgzn.hello.grpc.GreeterGrpc;
import dev.dgzn.hello.grpc.HelloRequest;
import dev.dgzn.hello.grpc.HelloResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApp implements CommandLineRunner {

    @GrpcClient("greeter") private GreeterGrpc.GreeterBlockingStub greeter;
    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String name = args.length > 0 ? args[0] : "World";
        HelloResponse response = greeter.sayHelloOnce(HelloRequest.newBuilder().setName(name).build());
        System.out.println("Greeter says: \""+response.getMessage()+"\"");
    }
}
