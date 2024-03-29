package com.company.crm.action;

import com.company.crm.entity.Role;
import com.company.crm.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Action 基类，设置公共属性和公共方法,供子类使用
 *
 * @author 胡荆陵
 */
public class BaseAction extends ActionSupport {

    public static final String PAGE_COUNT = "pageCount";  //总页数
    public static final String PAGE_NUMBER = "pageNumber"; //当前页码
    public static final String LOGIN_USER = "loginUser";// 保存登录用户ID的Session名称

    public static final String STATUS = "status";  //状态
    public static final String SUCCESS = "success";   //成功
	public static final String ERROR = "error";   //失败
    public static final String MESSAGE = "message";   //消息
	public static final String CONTENT = "content";   //内容
	public static final String LIST = "list";   //内容
	public static final String DEBUG = "debug";   //内容
    protected Pager pager;

    protected String id; //对象的主键, 查看/修改/删除 时使用
    protected String[] ids; //主键wd 集合，用于批量处理对象

    // 获取Attribute
    public Object getAttribute(String name) {
        return ServletActionContext.getRequest().getAttribute(name);
    }

    // 获取Request
    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    // 根据name获取Session中对象
    public Object getSession(String name) {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        return session.get(name);
    }

    // 获取Session
    public Map<String, Object> getSession() {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        return session;
    }

    // 设置Session
    public void setSession(String name, Object value) {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        session.put(name, value);
    }

    // 设置Attribute
    public void setAttribute(String name, Object value) {
        ServletActionContext.getRequest().setAttribute(name, value);
    }

    // 获取Parameter
    public String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    // 获取Response
    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    // 设置页面不缓存
    public void setResponseNoCache() {
        getResponse().setHeader("progma", "no-cache");
        getResponse().setHeader("Cache-Control", "no-cache");
        getResponse().setHeader("Cache-Control", "no-store");
        getResponse().setDateHeader("Expires", 0);
    }

    // 获取Application
    public ServletContext getApplication() {
        return ServletActionContext.getServletContext();
    }

    // 获取当前登录会员，若未登录则返回null
    public User getLoginUser() {
        return (User) getSession(LOGIN_USER);
    }

     // 获取当前登录会员，若未登录则返回null
    public String getLoginUserRoleRemark() {
        String result = "";
        Set<Role> set = getLoginUser().getRoleSet();
        int index = 0;
        for (Iterator<Role> iterator = set.iterator(); iterator.hasNext(); ) {
            Role role =  iterator.next();
            if(index == 0){
               result = role.getRemark();
            }else{
                result += ", "+ role.getRemark();
            }
            index++;
        }
        return result;
    }

    // 获取当前登录会员，若未登录则返回null
    public String getLoginUserAuthorities() {
        String result = "";
        Set<Role> set = getLoginUser().getRoleSet();
        int index = 0;
        for (Iterator<Role> iterator = set.iterator(); iterator.hasNext(); ) {
            Role role =  iterator.next();
            if(index == 0){
               result = role.getName();
            }else{
                result += ", "+ role.getName();
            }
            index++;
        }
        return result;
    }

    // AJAX输出，返回null
	public String ajax(String content, String type) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

    // 根据Map输出JSON，返回null
    public String ajaxJson(Map<String, String> jsonMap) {
//        JSONObject jsonObject = JSONObject.fromObject(jsonMap);
//        return ajax(jsonObject.toString(), "text/html");
        return ajax("", "text/html");
    }

    //getter & setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
