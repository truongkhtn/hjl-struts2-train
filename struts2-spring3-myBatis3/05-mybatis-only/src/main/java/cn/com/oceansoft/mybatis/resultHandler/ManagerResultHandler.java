package cn.com.oceansoft.mybatis.resultHandler;

import cn.com.oceansoft.mybatis.User;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class ManagerResultHandler implements ResultHandler{

    public void handleResult(ResultContext context) {
        User user = (User) context.getResultObject();
        System.out.println(user.toString());
    }
}
