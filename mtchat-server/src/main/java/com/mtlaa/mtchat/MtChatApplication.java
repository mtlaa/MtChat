package com.mtlaa.mtchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 实现群聊在线人数查询：在redis中使用一个string类型的key，记录当前在线的人数，在用户上线下线时的事件监听器中对缓存进行异步的处理，上线+1，下线-1
// TODO 敏感词过滤
// TODO 线程池推送
// TODO 分布式锁注解
// TODO 限流注解
// TODO 权限管理注解
// TODO 黑名单数据使用redis的set存储，实时更新不过期，避免缓存击穿。（使用mq或者本地消息表保证更新不失败）


@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableCaching
public class MtChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(MtChatApplication.class, args);
    }
}
