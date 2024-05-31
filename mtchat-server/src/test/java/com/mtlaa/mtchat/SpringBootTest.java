package com.mtlaa.mtchat;

import com.mtlaa.mtchat.chat.strategy.msghandler.MsgHandlerFactory;
import org.junit.jupiter.api.Test;

@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {

    @Test
    public void testOss(){
        MsgHandlerFactory.getStrategyNoNull(1);
    }
}
