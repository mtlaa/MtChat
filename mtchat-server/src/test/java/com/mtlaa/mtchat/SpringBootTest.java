package com.mtlaa.mtchat;

import com.mtlaa.mtchat.config.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@org.springframework.boot.test.context.SpringBootTest
@Slf4j
public class SpringBootTest {
    @Autowired
    @Qualifier(ThreadPoolConfig.WEBSOCKET_PUSH_EXECUTOR)
    private ThreadPoolTaskExecutor executor;

    @Test
    public void test() throws Exception {
        executor.execute(()->{
            if (true){
                throw new RuntimeException("运行出错");
            }
        });
    }
}

