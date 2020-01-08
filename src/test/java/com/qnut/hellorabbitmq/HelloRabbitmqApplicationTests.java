package com.qnut.hellorabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloRabbitmqApplicationTests {

    @Autowired
    private  Sender sender;

    @Test
    void contextLoads() {
    }

    @Test
    public void hello(){
        sender.sender();
        sender.senderMyQueue();
    }
}
