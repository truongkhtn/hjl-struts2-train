package cn.com.oceansoft.struts2.controller;

import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.service.UserService;
import cn.com.oceansoft.struts2.utils.UuidUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User Action 类
 *
 * @author 胡荆陵
 */
@Component("userAction")
public class UserAction extends BaseAction {

    private List<User> userList;
    private User user;

    private String condition; //查询条件
    private String value;//查询值

    private Map<String, String> availdIds; //可选id列表
    private List selectedIds; //已选id列表

    @Resource
    private UserService userService;

    public String initCreateUser() {
        user = null;
        return SUCCESS;
    }

    public String createUser() {
        if(StringUtils.isBlank(user.getName())){
            return INPUT;
        }
        user.setUserId(UuidUtil.genUuid());
        userService.save(user);
        return SUCCESS;
    }

    public String viewUser() {
        user = userService.getById(id);
        return SUCCESS;
    }

    public String initUpdateUser() {
        user = userService.getById(id);
        return SUCCESS;
    }

    public String updateUser() {
        if(StringUtils.isBlank(user.getName())){
            return INPUT;
        }
        userService.update(user);
        return SUCCESS;
    }

    public String deleteUser() {
        userService.delete(id);
        return SUCCESS;
    }

    public String getAll() {
        userList = userService.getAll();
        return SUCCESS;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    dynamic sql
    public String initQuery1() {
        user = null;
        return SUCCESS;
    }

    public String userQuery1() {
        this.userList = userService.getActiveUserByNameLike(user);
        return SUCCESS;
    }

    public String initQuery2() {
        user = null;
        return SUCCESS;
    }

    public String userQuery2() {
        user = new User();
        if (condition.equals("name")) {
            user.setName(value);
        } else if (condition.equals("email")) {
            user.setEmail(value);
        }
        this.userList = userService.getActiveUserLike(user);
        return SUCCESS;
    }

    public String initQuery3() {
        user = null;
        return SUCCESS;
    }

    public String userQuery3() {
        this.userList = userService.getUserLike(user);
        return SUCCESS;
    }

    public String initQuery4() {
        userList = userService.getAll();
        availdIds = new HashMap<String, String>();
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            availdIds.put(u.getName(), u.getUserId());
        }
        return SUCCESS;
    }

    public String userQuery4() {
        userList = userService.getByIds(selectedIds);
        return SUCCESS;
    }

    //getter & setter
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(List selectedIds) {
        this.selectedIds = selectedIds;
    }

    public Map<String, String> getAvaildIds() {
        return availdIds;
    }

    public void setAvaildIds(Map<String, String> availdIds) {
        this.availdIds = availdIds;
    }
}
