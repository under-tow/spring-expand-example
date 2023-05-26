package cn.under2.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicConfig {

    @Bean
    public TopicExchange setTopicExchange(){
        return new TopicExchange(RabbitConst.EXCHANGE_TOPIC);
    }

    @Bean
    public Queue topicQ1(){
        return new Queue(RabbitConst.QUEUE_TOPIC_Q1);
    }
    @Bean
    public Queue topicQ2(){
        return new Queue(RabbitConst.QUEUE_TOPIC_Q2);
    }
    @Bean
    public Queue topicQ3(){
        return new Queue(RabbitConst.QUEUE_TOPIC_Q3);
    }

    @Bean
    public Binding bindTopic1(){
        return BindingBuilder.bind(topicQ1()).to(setTopicExchange()).with("routeA.*");
    }

    @Bean
    public Binding bindTopic2(){
        return BindingBuilder.bind(topicQ2()).to(setTopicExchange()).with("*.routeB");
    }

    @Bean
    public Binding bindTopic3(){
        return BindingBuilder.bind(topicQ3()).to(setTopicExchange()).with("*");

    }

}
