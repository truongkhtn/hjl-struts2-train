import com.company.travel.ws.dto.UserLoginOutputType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import net.sf.json.processors.JsonBeanProcessor;

/**
 * Author: Hu jing ling
 * Date: 12-6-10
 * Description: put description for the type here...
 */
public class TestGson {

    public static void main(String[] args) {
        /*Gson gson = new Gson();
        System.out.println(gson.toJson(1));;//==>prints
        System.out.println(gson.toJson("abcd"));;//==>prints
        System.out.println(gson.toJson(new Long(10)));;//==>prints
        int[] values = {1};
        System.out.println( gson.toJson(values));;//==>prints
        System.out.println(gson.toJson(true));;//==>prints
        System.out.println(gson.toJson(new Boolean(false)));;//==>prints*/

        String returnResult = "{\"userLoginOutputType\":{\"success\":true,\"userId\":\"e761b6af-8e8b-45f2-a30d-fa179e0e8732\"}}";

        JsonObject jsonObject = new JsonParser().parse(returnResult).getAsJsonObject();
        String result = jsonObject.get("userLoginOutputType").toString();
        System.out.println(result);

        Gson gson = new Gson();
        UserLoginOutputType output = gson.fromJson(result, UserLoginOutputType.class);
        System.out.println(output.getUserId());

    }
}
