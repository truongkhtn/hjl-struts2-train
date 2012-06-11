import com.company.travel.ws.dto.MessageDTO;
import com.company.travel.ws.dto.MessageListDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

/**
 * Author: Hu jing ling
 * Date: 12-6-10
 * Description: put description for the type here...
 */
public class TestGson2 {

    public static void main(String[] args) {
        String returnResult = "{\"messageListDTO\":{\"unreadNum\":4,\"totalNum\":10,\"messageList\":[{\"logId\":\"dac23b9d-7a58-4b1d-9f7e-c0fe26fcc41a\",\"title\":\"GB77\",\"category\":\"其它A\",\"categorySeq\":2,\"readStatus\":\"read\",\"date\":\"2012-06-12\",\"content\":777888},{\"logId\":\"f10f6003-187f-4f34-ad0f-b5aa89e9eb01\",\"title\":\"GB8\",\"category\":\"其它B\",\"categorySeq\":3,\"readStatus\":\"read\",\"date\":\"2012-06-12\",\"content\":999999},{\"logId\":\"591a7fd1-8826-4c8a-9a8b-95d0d3f56279\",\"title\":\"GB7\",\"category\":\"假期\",\"categorySeq\":0,\"readStatus\":\"Unread\",\"date\":\"2012-06-12\",\"content\":7777},{\"logId\":\"2577e457-54f1-4e8d-ba09-5469d40bbd41\",\"title\":\"GB5\",\"category\":\"其它C\",\"categorySeq\":4,\"readStatus\":\"read\",\"date\":\"2012-06-12\",\"content\":555},{\"logId\":\"f2a8c668-7aef-4ff3-be9e-3de7dc7ec0a9\",\"title\":\"GB4\",\"category\":\"其它B\",\"categorySeq\":3,\"readStatus\":\"read\",\"date\":\"2012-06-12\",\"content\":44444444},{\"logId\":\"1caff382-fad5-4036-9a53-8dd3739d91bb\",\"title\":\"GB3\",\"category\":\"其它A\",\"categorySeq\":2,\"readStatus\":\"Unread\",\"date\":\"2012-06-12\",\"content\":3333333333},{\"logId\":\"7396698e-d905-475e-b739-5dd91f998380\",\"title\":\"GB2\",\"category\":\"通知\",\"categorySeq\":1,\"readStatus\":\"read\",\"date\":\"2012-06-12\",\"content\":2222222},{\"logId\":\"92f33a68-5e3a-42ca-8053-2b568e04d475\",\"title\":\"GB1\",\"category\":\"假期\",\"categorySeq\":0,\"readStatus\":\"Unread\",\"date\":\"2012-06-12\",\"content\":1111},{\"logId\":\"2c609f24-7625-4e6c-a42b-75549163f351\",\"title\":\"明天假期放假\",\"category\":\"假期\",\"categorySeq\":0,\"readStatus\":\"read\",\"date\":\"2012-06-07\",\"content\":\"明天开始放假\\r\\n时间: 11\\/11\\/2011 – 12\\/12\\/2012\"},{\"logId\":\"a927cf04-e3f7-4c02-a424-f61d33bf4583\",\"title\":\"特别通告\",\"category\":\"通知\",\"categorySeq\":1,\"readStatus\":\"Unread\",\"date\":\"2012-06-07\",\"content\":\"明天自己带饭\"}]}}";

        JsonObject jsonObject = new JsonParser().parse(returnResult).getAsJsonObject();
        String result = jsonObject.get("messageListDTO").toString();
        //System.out.println(result);

        Gson gson = new Gson();
        MessageListDTO output = gson.fromJson(result, MessageListDTO.class);
        //System.out.println(output.toString());

        Map<String, MessageGroupDTO> map = new HashMap<String, MessageGroupDTO>();
        System.out.println("原先：" + output.getMessageList().size());
        for (MessageDTO temp : output.getMessageList()) {
            System.out.println(temp.toString());
        }
        System.out.println("==============");
        for (MessageDTO message : output.getMessageList()) {
            //System.out.println(message);
            String category = message.getCategory();
            if (map.containsKey(category)) {
                MessageGroupDTO dto = map.get(category);
                if ("Unread".equals(message.getReadStatus())) {
                    dto.setTotalNum(String.valueOf(Integer.valueOf(dto.getTotalNum()) + 1));
                    dto.setUnreadNum(String.valueOf(Integer.valueOf(dto.getUnreadNum()) + 1));
                } else {
                    dto.setTotalNum(String.valueOf(Integer.valueOf(dto.getTotalNum()) + 1));
                }
            } else {
                MessageGroupDTO dto = new MessageGroupDTO();
                if ("Unread".equals(message.getReadStatus())) {
                    dto.setUnreadNum("1");
                } else {
                    dto.setUnreadNum("0");
                }
                dto.setCategory(message.getCategory());
                dto.setCategorySeq(message.getCategorySeq());
                dto.setTotalNum("1");
                map.put(category, dto);
            }
        }
        //System.out.println("map.size():"+map.size());

        List<MessageGroupDTO> list = new ArrayList<MessageGroupDTO>();
        for (String key : map.keySet()) {
            MessageGroupDTO dto = map.get(key);
            list.add(dto);
        }

        Collections.sort(list, new Comparator<MessageGroupDTO>() {
            public int compare(MessageGroupDTO o1, MessageGroupDTO o2) {
                if (o1.getCategorySeq() > o2.getCategorySeq()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (MessageGroupDTO dto : list) {
            System.out.println(dto);
        }


    }
}
