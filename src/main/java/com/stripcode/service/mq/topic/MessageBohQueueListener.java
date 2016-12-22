package com.stripcode.service.mq.topic;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

/**
 *负责消息接收
 *
 * @author Metro
 */

@Service
public class MessageBohQueueListener implements ChannelAwareMessageListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageBohQueueListener.class);

    private static final Gson gson = new Gson();

    public void onMessage(Message message, Channel channel) throws Exception {
        boolean isSuccess = true;
        String taskId = null;
        String content = new String(message.getBody());
        //DeliveryTag，对于每个Channel来说，每个消息都会有一个DeliveryTag，一般用接收消息的顺序来表示：1,2,3,4 等等
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            LOGGER.info("MessageQueueListener Receive Queue:" + message.toString()+ "\n");
            LOGGER.info("MessageQueueListener Receive Message:" + content+ "\n");
            LOGGER.info("MessageQueueListener End-------------------------------------------!");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (isSuccess) {
                //消息确认，接收方处理完消息后，向服务器发送消息确认，服务器再删除该消息
                channel.basicAck(deliveryTag, false);
                LOGGER.info(taskId + " is done! ACK it.");
            } else {
                if (!message.getMessageProperties().isRedelivered()) {
                    //消息拒收，接收端在收到消息后，向服务器发送：true-放回queue，重做该任务，注意避免死循环
                    channel.basicReject(deliveryTag, true);
                    LOGGER.info(taskId + " is fail! REJECT it");
                } else {
                    //消息拒收，接收端在收到消息后，向服务器发送：false-扔掉消息
                    channel.basicReject(deliveryTag, false);
                    LOGGER.info(taskId + " is fail! Resend to dead queue by Spring");
                }
            }
        }
    }

    public void getMessage(Message message){
        //message.toString()该方法可以获取主要的queque信息
        String AppId = message.getMessageProperties().getAppId();
        String ClusterId = message.getMessageProperties().getClusterId();
        String ContentEncoding = message.getMessageProperties().getContentEncoding();
        String ContentType = message.getMessageProperties().getContentType();
        String Expiration = message.getMessageProperties().getExpiration();
        String MessageId = message.getMessageProperties().getMessageId();
        String ReceivedExchange = message.getMessageProperties().getReceivedExchange();
        String ReceivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        String ReplyTo = message.getMessageProperties().getReplyTo();
        String Type = message.getMessageProperties().getType();
        String UserId = message.getMessageProperties().getUserId();
        String ContentLength = String.valueOf(message.getMessageProperties().getContentLength());
        String CorrelationId = String.valueOf(message.getMessageProperties().getCorrelationId());
        MessageDeliveryMode DeliveryMode = message.getMessageProperties().getDeliveryMode();
        String DeliveryTag = String.valueOf(message.getMessageProperties().getDeliveryTag());
        String Headers = String.valueOf(message.getMessageProperties().getHeaders());
        String MessageCount = String.valueOf(message.getMessageProperties().getMessageCount());
        String Priority = String.valueOf(message.getMessageProperties().getPriority());
        String Timestamp = String.valueOf(message.getMessageProperties().getTimestamp());
        String ReplyToAddress = String.valueOf(message.getMessageProperties().getReplyToAddress());
        System.out.println("AppId :"+ AppId);
        System.out.println("ClusterId :"+ ClusterId);
        System.out.println("ContentEncoding :"+ ContentEncoding);
        System.out.println("ContentType :"+ ContentType);
        System.out.println("Expiration :"+ Expiration);
        System.out.println("MessageId :"+ MessageId);
        System.out.println("ReceivedExchange :"+ ReceivedExchange);
        System.out.println("ReceivedRoutingKey :"+ ReceivedRoutingKey);
        System.out.println("ReplyTo :"+ ReplyTo);
        System.out.println("Type :"+ Type);
        System.out.println("UserId :"+ UserId);
        System.out.println("ContentLength :"+ ContentLength);
        System.out.println("CorrelationId :"+ CorrelationId);
        System.out.println("DeliveryMode :"+ DeliveryMode.toString());
        System.out.println("DeliveryTag :"+ DeliveryTag);
        System.out.println("Headers :"+ Headers);
        System.out.println("MessageCount :"+ MessageCount);
        System.out.println("Priority :"+ Priority);
        System.out.println("Timestamp :"+ Timestamp);
        System.out.println("ReplyToAddress :"+ ReplyToAddress);
    }

}
