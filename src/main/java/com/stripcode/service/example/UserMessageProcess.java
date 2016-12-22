package com.stripcode.service.example;


import com.stripcode.core.common.DetailRes;
import com.stripcode.service.rabbitmqsend.MessageProcess;

/**
 * Created by Metro on 16/6/28.
 */
public class UserMessageProcess implements MessageProcess<UserMessage> {
    @Override
    public DetailRes process(UserMessage userMessage) {
        System.out.println(userMessage);

        return new DetailRes(true, "");
    }
}
