import com.company.travel.ws.dto.UserLoginOutputType;
import com.google.gson.Gson;

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

        Gson gson = new Gson();
//        String returnResult = "{\"userLoginOutputType\":{\"success\":true,\"userId\":\"e761b6af-8e8b-45f2-a30d-fa179e0e8732\"}}";
        String returnResult = "{\"success\":true,\"userId\":\"e761b6af-8e8b-45f2-a30d-fa179e0e8732\"}";
        UserLoginOutputType output =  gson.fromJson(returnResult,UserLoginOutputType.class);
        System.out.println(output);

    }
}
