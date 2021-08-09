package com.lmmmowi.samples.rocketmq.basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class BasicSample {

    private static final String NAME_SERVER_ADDRESS = "localhost:9876";
    private static final String PRODUCER_GROUP = "basic-producer-group";
    private static final String CONSUMER_GROUP = "basic-consumer-group";
    private static final String TOPIC = "basic-topic";
    private static final String MESSAGE_CONTENT = "basic sample message content";

    public static void main(String[] args) throws Throwable {
        new BasicSample().run();
    }

    public void run() throws Throwable {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
        consumer.setNamesrvAddr(NAME_SERVER_ADDRESS);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(TOPIC, "*");
        consumer.registerMessageListener(new MessageListener());
        consumer.start();

        DefaultMQProducer producer = new DefaultMQProducer(PRODUCER_GROUP);
        producer.setNamesrvAddr(NAME_SERVER_ADDRESS);
        producer.start();
        for (int i = 0; i < 5; i++) {
            this.produce(producer);
            Thread.sleep(100);
        }

        producer.shutdown();
        consumer.shutdown();
    }

    private void produce(MQProducer producer) {
        try {
            byte[] body = MESSAGE_CONTENT.getBytes(StandardCharsets.UTF_8);
            Message message = new Message(TOPIC, body);
            SendResult sendResult = producer.send(message);
            log.info("send result: {}", sendResult);
        } catch (Exception e) {
            log.error("fail to produce message", e);
        }
    }

    private static class MessageListener implements MessageListenerConcurrently {
        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
            log.info("receive {} messages", list.size());

            for (MessageExt ext : list) {
                String msgId = ext.getMsgId();
                byte[] body = ext.getBody();
                String content = new String(body, StandardCharsets.UTF_8);
                log.info("receive message [{}]: {}", msgId, content);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    }
}
