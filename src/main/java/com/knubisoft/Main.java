package com.knubisoft;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        RabbitMQHelper helper = new RabbitMQHelper();
        String STOP_WORD = "stop";

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new PingPonger("Ping", STOP_WORD));
        executor.execute(new PingPonger("Pang", STOP_WORD));
        executor.execute(new PingPonger("Pong", STOP_WORD));

        helper.send("start");
        Thread.sleep(5000);
        helper.send(STOP_WORD);
        helper.closeConnection();
        executor.shutdown();
    }
}
