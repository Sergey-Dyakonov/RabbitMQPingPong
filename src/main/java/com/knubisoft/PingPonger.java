package com.knubisoft;

import com.rabbitmq.client.DeliverCallback;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;

public class PingPonger {
    @SneakyThrows
    public static void main(String[] args) {
        String word = args[0];
        String STOP_WORD = args[1];
        RabbitMQHelper helper = new RabbitMQHelper();

        DeliverCallback callback = (tag, delivery) -> {
            String receivedString = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(receivedString);
            if (receivedString.equals(STOP_WORD)) {
                helper.send(STOP_WORD);
                helper.closeConnection();
                System.out.println("PingPonger: " + word + " - finished");
            } else {
                try {
                    Thread.sleep(500);
                    helper.send(word);
                } catch (Exception e) {
                }
            }
        };

        helper.receive(callback);
    }
}
