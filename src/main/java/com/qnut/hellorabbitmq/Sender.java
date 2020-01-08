package com.qnut.hellorabbitmq;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description 消息生产者Sender使用AmqpTemplate接口的实例来实现消息的发送
 * @Author QNut
 * @Date 15：52 2020/01/08
 * @Version 1.0
 **/
@Slf4j
@Component
@Data
public class Sender {

    private final AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void sender(){
        String context = "我欲成仙 " + new Date();
        log.info("hello发送消息=========》》》》{}",context);
        this.amqpTemplate.convertAndSend("hello",context);
    }

    @RabbitHandler
    public void senderMyQueue(){
        String context = "快乐齐天" + new Date();
        log.info("myQueue发送消息=========》》》》{}",context);
        this.amqpTemplate.convertAndSend("myQueue",context);
    }

}
