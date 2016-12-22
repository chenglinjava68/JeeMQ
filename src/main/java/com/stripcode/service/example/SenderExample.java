package com.stripcode.service.example;

import com.stripcode.core.common.DetailRes;
import com.stripcode.service.rabbitmqsend.MQAccessBuilder;
import com.stripcode.service.rabbitmqsend.MessageSender;
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
public class SenderExample {
    private static final String EXCHANGE = "weixin";
    private static final String ROUTING = "weixin-to-pos";
    private static final String QUEUE = "weixin-to-pos";

    @Autowired
    ConnectionFactory connectionFactory;

    private MessageSender messageSender;

    @PostConstruct
    public void init() throws IOException, TimeoutException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        PoolExample poolExample = ac.getBean(PoolExample.class);
        MQAccessBuilder mqAccessBuilder = new MQAccessBuilder(connectionFactory);
        messageSender = mqAccessBuilder.buildMessageSender(EXCHANGE, ROUTING, QUEUE);
    }

    public DetailRes send(UserMessage userMessage) {
        return messageSender.send(userMessage);
    }
}
