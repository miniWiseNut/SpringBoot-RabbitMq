package com.qnut.hellorabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description Rabbitmq 配置类
 * @Author QNut
 * @Date 16：15 2020/01/08
 * @Version 1.0
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloConfig(){
        return new Queue("hello");
    }

    @Bean
    public Queue myQueueConfig(){
        return new Queue("myQueue");
    }
}
