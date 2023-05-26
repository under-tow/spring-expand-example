package cn.under2.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange setFanoutExchange(){
        return new FanoutExchange(RabbitConst.EXCHANGE_FANOUT);
    }
    @Bean
    public Queue fanoutQ1(){
        return new Queue(RabbitConst.QUEUE_FANOUT_Q1);
    }
    @Bean
    public Queue fanoutQ2(){
        return new Queue(RabbitConst.QUEUE_FANOUT_Q2);
    }
    @Bean
    public Queue fanoutQ3(){
        return new Queue(RabbitConst.QUEUE_FANOUT_Q3);
    }
    @Bean
    public Binding bindQ1(){
        return BindingBuilder.bind(fanoutQ1()).to(setFanoutExchange());
    }
    @Bean
    public Binding bindQ2(){
        return BindingBuilder.bind(fanoutQ2()).to(setFanoutExchange());
    }
    @Bean
    public Binding bindQ3(){
        return BindingBuilder.bind(fanoutQ3()).to(setFanoutExchange());
    }

}
