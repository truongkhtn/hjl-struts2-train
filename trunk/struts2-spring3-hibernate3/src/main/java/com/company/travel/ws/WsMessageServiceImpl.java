package com.company.travel.ws;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import com.company.travel.entity.MessageCategory;
import com.company.travel.entity.MessageLog;
import com.company.travel.service.MessageCategoryService;
import com.company.travel.service.MessageLogService;
import com.company.travel.utils.MyConstant;
import com.company.travel.ws.dto.MessageCategoryDTO;
import com.company.travel.ws.dto.MessageCategoryListDTO;
import com.company.travel.ws.dto.MessageDTO;
import com.company.travel.ws.dto.MessageListDTO;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

        //需求变更:2012-7-22,仅显示最近一周的消息
        list = excludeMessageByDays(list, 7);

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

    private List<MessageLog> excludeMessageByDays(List<MessageLog> list , int days) {
        List<MessageLog> result = new ArrayList<MessageLog>();
//        Date markDate = calendar.getTime();
        long time = new Date().getTime();
        long target = time - 1000*60*60*24*days;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(target);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date markDate = calendar.getTime();
        for(MessageLog messageLog : list){
            if(messageLog.getCreateDate().after(markDate)){
                result.add(messageLog);
            }
        }
        return result;
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
