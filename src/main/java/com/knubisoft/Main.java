package com.knubisoft;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        RabbitMQHelper helper = new RabbitMQHelper();
        String STOP_WORD = "stop";

        PingPonger.main(new String[]{"Ping", STOP_WORD});
        PingPonger.main(new String[]{"Pong", STOP_WORD});

        helper.send("start");
        Thread.sleep(5000);
        helper.send(STOP_WORD);
        helper.closeConnection();
    }
}
