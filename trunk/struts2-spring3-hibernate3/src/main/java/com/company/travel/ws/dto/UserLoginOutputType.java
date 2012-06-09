package com.company.travel.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 用户登陆验证返回对象
 */
@XmlRootElement
@XmlType(propOrder = {
    "success","userId"
})
public class UserLoginOutputType {

    private boolean success;   // 是否登陆成功
    private String userId;    //  用户 ID

    public UserLoginOutputType() {
    }

    @Override
    public String toString() {
        return "UserLoginOutputType{" +
                "userId='" + userId + '\'' +
                ", success=" + success +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
