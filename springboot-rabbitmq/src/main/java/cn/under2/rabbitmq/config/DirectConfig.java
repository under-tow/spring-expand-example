package cn.under2.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    @Bean
    public Queue directQueue(){
        return new Queue(RabbitConst.QUEUE_DIRECT);
    }
}
