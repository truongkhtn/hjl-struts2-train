package com.company.travel.ws;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import com.company.travel.entity.MessageLog;
import com.company.travel.service.MessageLogService;
import com.company.travel.utils.MyConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wsMessageService")
public class WsMessageServiceImpl implements WsMessageService {

    @Resource
    private MessageLogService messageLogService;

    public Response getMessageById(String userId) {
        List<MessageLog> list = messageLogService.getByUserId(userId);

        return Response.ok(list).build();
    }

    public Response readMessage(String msgId) {
        MessageLog messageLog = messageLogService.get(msgId);
        messageLog.setReadStatus(MyConstant.READ);
        messageLogService.update(messageLog);
        return Response.ok().build();
    }
}
