package com.company.travel.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 用户登陆验证返回对象
 * 1) 使用 @XmlRootElement: 避免以下异常
 * No message body writer has been found for response class
 * 2) 使用 @XmlType : 按指定顺序输出属性值
 */

@XmlRootElement
@XmlType(propOrder = {
        "success", "userId"
})
public class UserLoginDTO {

    private boolean success;   // 是否登陆成功
    private String userId;    //  用户 ID

    public UserLoginDTO() {
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
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
