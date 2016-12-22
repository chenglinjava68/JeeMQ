package com.stripcode.service.example;

import com.stripcode.core.common.Constants;
import com.stripcode.service.rabbitmqsend.MQAccessBuilder;
import com.stripcode.service.rabbitmqsend.MessageProcess;
import com.stripcode.service.rabbitmqsend.ThreadPoolConsumer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by Metro on 16/6/28.
 */
@Service
public class PoolExample {
    private static final String EXCHANGE = "weixin";
    private static final String ROUTING = "weixin-to-pos";
    private static final String QUEUE = "weixin-to-pos";

    @Autowired
    ConnectionFactory connectionFactory;

    private ThreadPoolConsumer<UserMessage> threadPoolConsumer;

    @PostConstruct
    public void init() {
        MQAccessBuilder mqAccessBuilder = new MQAccessBuilder(connectionFactory);
        MessageProcess<UserMessage> messageProcess = new UserMessageProcess();

        threadPoolConsumer = new ThreadPoolConsumer.ThreadPoolConsumerBuilder<UserMessage>()
                .setThreadCount(Constants.THREAD_COUNT).setIntervalMils(Constants.INTERVAL_MILS)
                .setExchange(EXCHANGE).setRoutingKey(ROUTING).setQueue(QUEUE)
                .setMQAccessBuilder(mqAccessBuilder).setMessageProcess(messageProcess)
                .build();
    }

    public void start() throws IOException {
        threadPoolConsumer.start();
    }

    public void stop() {
        threadPoolConsumer.stop();
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        PoolExample poolExample = ac.getBean(PoolExample.class);
        final SenderExample senderExample = ac.getBean(SenderExample.class);

        //poolExample.start();

        new Thread(new Runnable() {
            int id = 0;

            @Override
            public void run() {
                while (true) {
                    senderExample.send(new UserMessage(id++, "" + System.nanoTime()));
                    System.out.println("消息发送确认成功");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
