package com.qnut.hellorabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description 接收mq消息
 * @Author QNut
 * @Date 15:23 2020/01/08
 * @Version 1.0
 **/
@Slf4j
@Component
public class MqReceiver {

//    /**
//     * @Description
//     * 1. 手动创建，需在RabbitMQ中手动创建myQueue1 队列，否则报错
//     * @Author QNut
//     * @Date 2020/1/8 15:25
//     * @param message
//     * @return
//     **/
//    @RabbitListener(queues = "myQueue1")
//    public void process1(String message){
//        log.info("MqReceiver1: {}", message);
//    }

    /**
     * @Description
     * 2. 自动创建队列
     * @Author QNut
     * @Date 2020/1/8 15:25
     * @param message
     * @return 
     **/
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    public void process2(String message){
        log.info("hello接收消息=====》》》》》: {}", message);

    }

    /**
     * @Description
     * 3. 自动创建队列，Exchange 与 Queue绑定
     * @Author QNut
     * @Date 2020/1/8 15:24
     * @param message 消息
     * @return 
     **/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("testExChange")
    ))
    public void process3(String message){
        log.info("MqReceiver接收消息=====》》》》》: {}", message);
    }


//    @RabbitListener(bindings = @QueueBinding(
//            exchange = @Exchange("myOrder"),
//            key = "computer",
//            value = @Queue("computerOrder")
//    ))
//    public void processComputer(String message){
//        log.info("computer MqReceiver: {}", message);
//
//    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            exchange = @Exchange("myOrder"),
//            key = "fruit",
//            value = @Queue("fruitOrder")
//    ))
//    public void processFruit(String message){
//        log.info("fruit MqReceiver: {}", message);
//
//    }


}
