package com.company.crm.utils;

import com.company.crm.action.BaseAction;
import com.company.crm.entity.User;
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

        ActionContext ctx = actionInvocation.getInvocationContext();
        User u = (User) ctx.getSession().get(BaseAction.LOGIN_USER);

        //登录或已登陆，就放行action
        if (url.toLowerCase().contains("login")
                || u != null) {
            return actionInvocation.invoke();
        }else {
            return "toLogin";
        }
    }
}
