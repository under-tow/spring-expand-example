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

}
