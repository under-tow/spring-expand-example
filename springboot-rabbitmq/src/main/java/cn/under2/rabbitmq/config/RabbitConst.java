package cn.under2.rabbitmq.config;

public class RabbitConst {

    public static final String QUEUE_QUORUM = "quorumQueue";

    // direct 直连模式
    public static final String QUEUE_DIRECT = "directQueue";

    // fanout 广播模式
    public static final String EXCHANGE_FANOUT = "fanoutExchange";
    public static final String QUEUE_FANOUT_Q1 = "fanout.q1";
    public static final String QUEUE_FANOUT_Q2 = "fanout.q2";
    public static final String QUEUE_FANOUT_Q3 = "fanout.q3";
    public static final String QUEUE_FANOUT_Q4 = "fanout.q4";

    // topic 主题模式
    public static final String EXCHANGE_TOPIC = "topicExchange";
    public static final String QUEUE_TOPIC_Q1 = "topic.q1";
    public static final String QUEUE_TOPIC_Q2 = "topic.q2";
    public static final String QUEUE_TOPIC_Q3 = "topic.q3";
}
