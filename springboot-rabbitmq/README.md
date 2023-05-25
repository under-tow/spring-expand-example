# SpringBoot整合RabbitMQ

### 1. POM依赖

RabbitMq为amqp协议

```xml
<!--   支持amqp协议即可  -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

### 2. 配置文件


```yml
server.port=端口
spring.rabbitmq.host=IP地址
spring.rabbitmq.port=端口
spring.rabbitmq.username=用户名
spring.rabbitmq.password=密码
spring.rabbitmq.virtual-host=虚拟主机

```
### 3. 代码结构

- config包：以注解形式配置交换器、队列、队列与交换机的关系
- consumer包： 消费者 @RabbitListener(queues=绑定指定队列)
- producer包： 生产者 利用RabbitTemplate来发送消息