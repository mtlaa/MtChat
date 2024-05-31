package com.mtlaa.mtchat.user.service.handler;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class MsgHandler extends AbstractHandler {



    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
//        if (true) {
//            WxMsg msg = new WxMsg();
//            msg.setOpenId(wxMessage.getFromUser());
//            msg.setMsg(wxMessage.getContent());
//            wxMsgDao.save(msg);
//            return null;
//        }
//        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
//            //可以选择将消息保存到本地
//        }
//
//        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
//        try {
//            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
//                    && weixinService.getKefuService().kfOnlineList()
//                    .getKfOnlineList().size() > 0) {
//                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
//                        .fromUser(wxMessage.getToUser())
//                        .toUser(wxMessage.getFromUser()).build();
//            }
//        } catch (WxErrorException e) {
//            e.printStackTrace();
//        }
//
//        //组装回复消息
//        String content = "收到信息内容：" + JSONUtil.toJsonStr(wxMessage);
//
//        return new TextBuilder().build(content, wxMessage, weixinService);

        return null;
    }

}
