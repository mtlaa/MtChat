package com.mtlaa.mtchat.chat.controller;


import com.mtlaa.mtchat.chat.service.ContactService;
import com.mtlaa.mtchat.domain.chat.vo.request.member.MemberReq;
import com.mtlaa.mtchat.domain.chat.vo.response.ChatMemberResp;
import com.mtlaa.mtchat.domain.common.vo.response.ApiResult;
import com.mtlaa.mtchat.domain.common.vo.response.CursorPageBaseResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Create 2024/1/10 14:42
 */
@RestController
@RequestMapping("/capi/room")
@Api(tags = "聊天室相关接口")
@Slf4j
public class RoomController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/public/group/member/page")
    @ApiOperation("群成员列表")
    public ApiResult<CursorPageBaseResp<ChatMemberResp>> getMemberPage(@Valid MemberReq request) {
        return ApiResult.success(contactService.getMemberPage(request));
    }
}
