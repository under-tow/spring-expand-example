package cn.under2.rabbitmq.consumer;

import cn.under2.rabbitmq.config.RabbitConst;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = RabbitConst.QUEUE_DIRECT,containerFactory = "qos_4")
    public void directConsumer(Message message, Channel channel, String messageStr){
        System.out.println("QUEUE_DIRECT receive : " + messageStr);

    }

    @RabbitListener(queues = RabbitConst.QUEUE_FANOUT_Q1)
    public void fanoutConsumer1(Message message, Channel channel, String messageStr){
        System.out.println("QUEUE_FANOUT_Q1 receive : " + messageStr);
    }

    @RabbitListener(queues = RabbitConst.QUEUE_FANOUT_Q2)
    public void fanoutConsumer2(Message message, Channel channel, String messageStr){
        System.out.println("QUEUE_FANOUT_Q2 receive : " + messageStr);
    }

    @RabbitListener(queues = RabbitConst.QUEUE_FANOUT_Q3)
    public void fanoutConsumer3(Message message, Channel channel, String messageStr){
        System.out.println("QUEUE_FANOUT_Q3 receive : " + messageStr);
    }

    @RabbitListener(queues = RabbitConst.QUEUE_TOPIC_Q1)
    public void topicConsumer1(Message message, Channel channel, String messageStr){
        System.out.println("QUEUE_TOPIC_Q1 receive : " + messageStr);
    }

    @RabbitListener(queues = RabbitConst.QUEUE_TOPIC_Q2)
    public void topicConsumer2(Message message, Channel channel, String messageStr){
        System.out.println("QUEUE_TOPIC_Q2 receive : " + messageStr);
    }

    @RabbitListener(queues = RabbitConst.QUEUE_TOPIC_Q3)
    public void topicConsumer3(Message message, Channel channel, String messageStr){
        System.out.println("QUEUE_TOPIC_Q3 receive : " + messageStr);
    }
}
