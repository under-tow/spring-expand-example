package cn.under2.rabbitmq.producer;

import cn.under2.rabbitmq.config.RabbitConst;
import com.rabbitmq.client.MessageProperties;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RestController
public class ProducerController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/direct")
    public Object directSend(String message) {

        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.send(
                RabbitConst.QUEUE_DIRECT,
                new Message(message.getBytes(StandardCharsets.UTF_8)));
        return "message sent + " + message;
    }

}
