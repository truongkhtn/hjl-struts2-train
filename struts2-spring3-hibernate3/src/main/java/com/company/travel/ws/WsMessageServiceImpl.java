package com.company.travel.ws;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import com.company.travel.entity.Message;
import com.company.travel.entity.MessageLog;
import com.company.travel.service.MessageLogService;
import com.company.travel.utils.MyConstant;
import com.company.travel.ws.dto.MessageDTO;
import com.company.travel.ws.dto.MessageListDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service("wsMessageService")
public class WsMessageServiceImpl implements WsMessageService {

    @Resource
    private MessageLogService messageLogService;

    public Response getMessageById(String userId) {
        List<MessageLog> list = messageLogService.getByUserId(userId);
        int unreadNum = 0;
        int totalNum = list.size();
        List<MessageDTO> messageList = new ArrayList<MessageDTO>();
        for (MessageLog log : list) {
            MessageDTO dto = new MessageDTO();
            dto.setLogId(log.getId());
            dto.setTitle(log.getMessage().getTitle());
            dto.setCategory(log.getMessage().getMessageCategory().getName());
            dto.setReadStatus(log.getReadStatus());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String sDate = df.format(log.getMessage().getDate());
            dto.setDate(sDate);
            dto.setContent(log.getMessage().getContent());
            messageList.add(dto);
            if (log.getUnRead()) {
                unreadNum++;
            }
        }
        MessageListDTO messageListDTO = new MessageListDTO(unreadNum, totalNum, messageList);
        return Response.ok(messageListDTO).build();
    }

    public Response readMessage(String msgId) {
        MessageLog messageLog = messageLogService.get(msgId);
        messageLog.setReadStatus(MyConstant.READ);
        messageLogService.update(messageLog);
        return Response.ok().build();
    }
}
