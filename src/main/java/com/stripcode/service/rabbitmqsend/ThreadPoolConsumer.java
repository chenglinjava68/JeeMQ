package com.stripcode.service.rabbitmqsend;

import com.stripcode.core.common.DetailRes;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Metro on 16/5/23.
 */
@Log
public class ThreadPoolConsumer<T> {
    private ExecutorService executor;
    private volatile boolean stop = false;
    private final ThreadPoolConsumerBuilder<T> infoHolder;

    //构造器
    public static class ThreadPoolConsumerBuilder<T> {
        int threadCount;
        long intervalMils;
        MQAccessBuilder mqAccessBuilder;
        String exchange;
        String routingKey;
        String queue;
        MessageProcess<T> messageProcess;

        public ThreadPoolConsumerBuilder<T> setThreadCount(int threadCount) {
            this.threadCount = threadCount;

            return this;
        }

        public ThreadPoolConsumerBuilder<T> setIntervalMils(long intervalMils) {
            this.intervalMils = intervalMils;

            return this;
        }

        public ThreadPoolConsumerBuilder<T> setMQAccessBuilder(MQAccessBuilder mqAccessBuilder) {
            this.mqAccessBuilder = mqAccessBuilder;

            return this;
        }

        public ThreadPoolConsumerBuilder<T> setExchange(String exchange) {
            this.exchange = exchange;

            return this;
        }

        public ThreadPoolConsumerBuilder<T> setRoutingKey(String routingKey) {
            this.routingKey = routingKey;

            return this;
        }

        public ThreadPoolConsumerBuilder<T> setQueue(String queue) {
            this.queue = queue;

            return this;
        }

        public ThreadPoolConsumerBuilder<T> setMessageProcess(MessageProcess<T> messageProcess) {
            this.messageProcess = messageProcess;

            return this;
        }

        public ThreadPoolConsumer<T> build() {
            return new ThreadPoolConsumer<T>(this);
        }
    }

    private ThreadPoolConsumer(ThreadPoolConsumerBuilder<T> threadPoolConsumerBuilder) {
        this.infoHolder = threadPoolConsumerBuilder;
        executor = Executors.newFixedThreadPool(threadPoolConsumerBuilder.threadCount);
    }

    //1 构造messageConsumer
    //2 执行consume
    public void start() throws IOException {
        for (int i = 0; i < infoHolder.threadCount; i++) {
            //1
            final MessageConsumer messageConsumer = infoHolder.mqAccessBuilder.buildMessageConsumer(infoHolder.exchange,
                    infoHolder.routingKey, infoHolder.queue, infoHolder.messageProcess);

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (!stop) {
                        try {
                            //2
                            DetailRes detailRes = messageConsumer.consume();

                            if (infoHolder.intervalMils > 0) {
                                try {
                                    Thread.sleep(infoHolder.intervalMils);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    log.info("interrupt " + e);
                                }
                            }

                            if (!detailRes.isSuccess()) {
                                log.info("run error " + detailRes.getErrMsg());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.info("run exception " + e);
                        }
                    }
                }
            });
        }
    }

    public void stop() {
        this.stop = true;
    }
}
