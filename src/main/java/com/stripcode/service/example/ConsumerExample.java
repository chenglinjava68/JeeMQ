package com.stripcode.service.example;


import com.stripcode.core.common.DetailRes;
import com.stripcode.service.rabbitmqsend.MQAccessBuilder;
import com.stripcode.service.rabbitmqsend.MessageConsumer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Metro on 16/6/28.
 */
@Service
public class ConsumerExample {
    private static final String EXCHANGE = "mq_message_exchange";
    private static final String ROUTING = "mq_message_queue_boh_chargeback";
    private static final String QUEUE = "mq_message_queue_boh_chargeback";

    @Autowired
    ConnectionFactory connectionFactory;

    private MessageConsumer messageConsumer;

    @PostConstruct
    public void init() throws IOException, TimeoutException {
        MQAccessBuilder mqAccessBuilder = new MQAccessBuilder(connectionFactory);
        messageConsumer = mqAccessBuilder.buildMessageConsumer(EXCHANGE, ROUTING, QUEUE, new UserMessageProcess());
    }

    public DetailRes consume() {
        return messageConsumer.consume();
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerExample consumerExample = ac.getBean(ConsumerExample.class);


    }
}
