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

        String s = "false";
        Gson gson = new Gson();
        Boolean b =  gson.fromJson(s,java.lang.Boolean.class);
        //System.out.println(b);
        if(b){
            System.out.println("true !!!!");
        }else{
            System.out.println("false !!!!");
        }



    }
}
