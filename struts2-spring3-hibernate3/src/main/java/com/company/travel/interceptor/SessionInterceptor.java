package com.company.travel.interceptor;

import com.company.travel.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户登陆验证拦截器
 */
public class SessionInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //取得请求的URL
        String url = ServletActionContext.getRequest().getRequestURL().toString();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        //对登录与注销请求直接放行,不予拦截
        if (url.indexOf("login.action") != -1 || url.indexOf("logout.action") != -1) {
            return actionInvocation.invoke();
        }
        ActionContext ctx = actionInvocation.getInvocationContext();
        User u = (User) ctx.getSession().get("loginUser");
        if (u != null && u.isAdmin()) {
            return actionInvocation.invoke();
        } else {
            return "tologin";
        }
    }
}
