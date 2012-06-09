import com.company.travel.ws.dto.UserLoginDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Author: Hu jing ling
 * Date: 12-6-10
 * Description: put description for the type here...
 */
public class TestGson {

    public static void main(String[] args) {
//        String returnResult = "{\"userLoginDTO\":{\"success\":true,\"userId\":\"e761b6af-8e8b-45f2-a30d-fa179e0e8732\"}}";
        String returnResult = "{\"userLoginDTO\":{\"success\":false}}";

        JsonObject jsonObject = new JsonParser().parse(returnResult).getAsJsonObject();
        String result = jsonObject.get("userLoginDTO").toString();
        System.out.println(result);

        Gson gson = new Gson();
        UserLoginDTO output = gson.fromJson(result, UserLoginDTO.class);
        System.out.println(output.isSuccess());

    }
}
