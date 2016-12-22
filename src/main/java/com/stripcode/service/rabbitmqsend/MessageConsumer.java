package com.stripcode.service.rabbitmqsend;


import com.stripcode.core.common.DetailRes;

/**
 * Created by Metro on 16/5/12.
 */
public interface MessageConsumer {
    DetailRes consume();
}
