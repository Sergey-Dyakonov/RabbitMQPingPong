package com.knubisoft;

import com.rabbitmq.client.DeliverCallback;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;

/**
 * Represents message exchanging between several {@code Runnable} using RabbitMQ
 */
@AllArgsConstructor
public class PingPonger implements Runnable {
    private String word;
    private String STOP_WORD;

    @SneakyThrows
    public void run() {
        RabbitMQHelper helper = new RabbitMQHelper();
        DeliverCallback callback = (tag, delivery) -> {
            String receivedString = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(Thread.currentThread().getName() + ": " + receivedString);
            if (receivedString.equals(STOP_WORD)) {
                helper.send(STOP_WORD);
                helper.closeConnection();
                System.out.println(Thread.currentThread().getName() + ": " + word + " - finished");
            } else {
                try {
                    Thread.sleep(250);
                    helper.send(word);
                } catch (Exception e) {
                }
            }
        };
        helper.receive(callback);
    }
}
