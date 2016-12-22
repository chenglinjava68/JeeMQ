package com.stripcode.service.rabbitmqsend;


import com.stripcode.core.common.DetailRes;

/**
 * Created by Metro on 16/5/11.
 */
public interface MessageProcess<T> {
    DetailRes process(T message);
}
