package com.mtlaa.mtchat.event;

import com.mtlaa.mtchat.domain.user.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserOfflineEvent extends ApplicationEvent {
    private final User user;
    public UserOfflineEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}