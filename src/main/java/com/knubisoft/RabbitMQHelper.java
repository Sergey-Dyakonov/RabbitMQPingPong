package com.knubisoft;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;


public class RabbitMQHelper {
    private final String QUEUE = "QUEUE";
    private final String HOST = "localhost";
    private final Connection connection;
    private final Channel channel;

    @SneakyThrows
    public RabbitMQHelper() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE, false, false, false, null);
    }

    @SneakyThrows
    public void closeConnection() {
        connection.close();
    }

    @SneakyThrows
    public void send(String message) {
        channel.basicPublish("", QUEUE, null, message.getBytes());
    }

    @SneakyThrows
    public void receive(DeliverCallback callback) {
        channel.basicConsume(QUEUE, true, callback, tag -> {
        });
    }
}
