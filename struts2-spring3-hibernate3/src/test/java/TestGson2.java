
import com.company.travel.ws.dto.MessageListDTO;
import com.company.travel.ws.dto.UserLoginDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Author: Hu jing ling
 * Date: 12-6-10
 * Description: put description for the type here...
 */
public class TestGson2 {

    public static void main(String[] args) {
//        String returnResult = "{\"messageListDTO\":{\"unreadNum\":2,\"totalNum\":2,\"messageList\":[{\"logId\":\"2c609f24-7625-4e6c-a42b-75549163f351\",\"title\":\"明天假期放假\",\"category\":\"假期\",\"readStatus\":\"Unread\",\"date\":\"2012-06-07\",\"content\":\"明天开始放假\\r\\n时间: 11\\/11\\/2011 – 12\\/12\\/2012\"},{\"logId\":\"a927cf04-e3f7-4c02-a424-f61d33bf4583\",\"title\":\"特别通告\",\"category\":\"通知\",\"readStatus\":\"Unread\",\"date\":\"2012-06-07\",\"content\":\"明天自己带饭\"}]}}";
        String returnResult = "{\"messageListDTO\":{\"unreadNum\":0,\"totalNum\":0}}";

        JsonObject jsonObject = new JsonParser().parse(returnResult).getAsJsonObject();
        String result = jsonObject.get("messageListDTO").toString();
        System.out.println(result);

        Gson gson = new Gson();
        MessageListDTO output = gson.fromJson(result, MessageListDTO.class);
        System.out.println(output.toString());

    }
}
