package com.company.travel.interceptor;

import com.company.travel.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-5-22
 * Time: 下午12:49
 * To change this template use File | Settings | File Templates.
 */
public class SessionInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext ctx=actionInvocation.getInvocationContext();
        User u = (User)ctx.getSession().get("loginUser");
        if(u != null && u.isAdmin()){
            return actionInvocation.invoke();
        }else{
            return "invalid";
        }
    }
}
