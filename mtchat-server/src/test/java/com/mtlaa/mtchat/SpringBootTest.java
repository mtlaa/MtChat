package com.mtlaa.mtchat;

import com.mtlaa.mtchat.annotation.RateLimiter;
import com.mtlaa.mtchat.config.RedisConfig;
import com.mtlaa.mtchat.config.ThreadPoolConfig;
import com.mtlaa.mtchat.utils.LockService;
import com.mtlaa.mtchat.utils.SpELUtil;
import com.mtlaa.mychat.transaction.annotation.SecureInvoke;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@org.springframework.boot.test.context.SpringBootTest
@Slf4j
public class SpringBootTest {
    @Autowired
    @Qualifier(ThreadPoolConfig.WEBSOCKET_PUSH_EXECUTOR)
    private ThreadPoolTaskExecutor executor;

    @Autowired
    private LockService lockService;

    @Test
    public void test() throws Throwable {
    }

}

