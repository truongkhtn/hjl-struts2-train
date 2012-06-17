package com.company.travel.ws;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import com.company.travel.entity.Message;
import com.company.travel.entity.MessageCategory;
import com.company.travel.entity.MessageLog;
import com.company.travel.service.MessageCategoryService;
import com.company.travel.service.MessageLogService;
import com.company.travel.utils.MyConstant;
import com.company.travel.ws.dto.MessageCategoryDTO;
import com.company.travel.ws.dto.MessageCategoryListDTO;
import com.company.travel.ws.dto.MessageDTO;
import com.company.travel.ws.dto.MessageListDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * WsMessageService 接口实现类
 */
@Service("wsMessageService")
public class WsMessageServiceImpl implements WsMessageService {

    @Resource
    private MessageLogService messageLogService;
    @Resource
    private MessageCategoryService messageCategoryService;

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
            dto.setCategorySeq(log.getMessage().getMessageCategory().getSeq());
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

    public Response getCategoryList() {
        List<MessageCategory> list = messageCategoryService.getAllBySeq();
        MessageCategoryListDTO dto = new MessageCategoryListDTO();
        for(MessageCategory category : list){
            MessageCategoryDTO temp = new MessageCategoryDTO();
            temp.setId(category.getId());
            temp.setName(category.getName());
            temp.setSeq(category.getSeq());
            dto.getMessageCategoryList().add(temp);
        }
        return Response.ok(dto).build();
    }
}
