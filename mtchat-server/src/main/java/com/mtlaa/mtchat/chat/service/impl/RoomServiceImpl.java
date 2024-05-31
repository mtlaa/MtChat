package com.mtlaa.mtchat.chat.service.impl;


import com.mtlaa.mtchat.chat.dao.RoomDao;
import com.mtlaa.mtchat.chat.dao.RoomFriendDao;
import com.mtlaa.mtchat.chat.service.RoomService;
import com.mtlaa.mtchat.domain.chat.entity.Room;
import com.mtlaa.mtchat.domain.chat.entity.RoomFriend;
import com.mtlaa.mtchat.domain.chat.enums.HotFlagEnum;
import com.mtlaa.mtchat.domain.chat.enums.RoomTypeEnum;
import com.mtlaa.mtchat.domain.common.enums.NormalOrNoEnum;
import com.mtlaa.mtchat.utils.RoomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Create 2023/12/21 19:50
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private RoomFriendDao roomFriendDao;


    /**
     * 创建一个单聊
     * 插入room表、room_friend表
     */
    @Override
    @Transactional
    public RoomFriend createFriendRoom(Long uid, Long uid1) {
        String roomKey = RoomUtils.generateRoomKey(uid, uid1);
        RoomFriend roomFriend = roomFriendDao.getByRoomKey(roomKey);
        if(Objects.nonNull(roomFriend)){
            restoreRoomIfNeed(roomFriend);
        }else{
            Room room = createRoom(RoomTypeEnum.FRIEND);
            roomFriend = RoomFriend.builder()
                    .roomId(room.getId())
                    .roomKey(roomKey)
                    .uid1(uid)
                    .uid2(uid1)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .status(NormalOrNoEnum.NORMAL.getStatus())
                    .build();
            roomFriendDao.save(roomFriend);
        }
        return roomFriend;
    }

    /**
     * 禁用房间，status = not normal
     */
    @Override
    public void disableFriendRoom(Long uid, Long targetUid) {
        String roomKey = RoomUtils.generateRoomKey(uid, targetUid);
        roomFriendDao.disableRoom(roomKey);
    }

    @Override
    public RoomFriend getFriendRoom(Long uid, Long uid1) {
        String roomKey = RoomUtils.generateRoomKey(uid, uid1);
        return roomFriendDao.getByRoomKey(roomKey);
    }

    private Room createRoom(RoomTypeEnum roomTypeEnum) {
        Room room = Room.builder()
                .hotFlag(HotFlagEnum.NOT.getType())
                .type(roomTypeEnum.getType())
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        roomDao.save(room);
        return room;
    }

    /**
     * 重新添加好友--判断是否要恢复房间
     */
    private void restoreRoomIfNeed(RoomFriend roomFriend) {
        if(roomFriend.getStatus().equals(NormalOrNoEnum.NOT_NORMAL.getStatus())){
            // 房间被禁用，需要恢复
            roomFriendDao.restoreRoom(roomFriend.getId());
        }
    }


}
