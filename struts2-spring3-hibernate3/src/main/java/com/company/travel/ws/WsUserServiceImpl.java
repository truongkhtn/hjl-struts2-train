package com.company.travel.ws;

import com.company.travel.entity.Group;
import com.company.travel.entity.User;
import com.company.travel.service.GroupService;
import com.company.travel.service.UserService;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import com.company.travel.utils.StringGenerator;
import com.company.travel.ws.dto.UserLoginDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * WsUserService 接口实现类
 */
@Service("wsUserService")
public class WsUserServiceImpl implements WsUserService {

    @Resource
    private UserService userService;
    @Resource
    private GroupService groupService;

    public Response userLogin(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean result = userService.login(user);
        UserLoginDTO output = new UserLoginDTO();
        if (result) {
            user = userService.getUserByUsername(username);
            output.setSuccess(true);
            output.setUserId(user.getId());
            output.setUsername(user.getUsername());
            output.setPublicAccount(user.getUsername().indexOf("public") > -1);
        } else {
            output.setSuccess(false);
        }
        return Response.ok(output).build();
    }

    public Response register() {
        //获得随机public账号
        User publicUser = new User();
        String random = StringGenerator.getRandomString("public", 6);
        publicUser.setUsername(random);
        publicUser.setPassword("");
        publicUser.setRealname(random);
        //public 账户默认加入 组别A，组别B，组别C
        Group groupA = groupService.get("name" ,"组别A");
        Group groupB = groupService.get("name" ,"组别B");
        Group groupC = groupService.get("name" ,"组别C");
        Set<Group> groupSet = new HashSet<Group>();
        groupSet.add(groupA);
        groupSet.add(groupB);
        groupSet.add(groupC);
        publicUser.setGroupSet(groupSet);
        userService.save(publicUser);
        //返回 dto
        UserLoginDTO dto = new UserLoginDTO();
        dto.setSuccess(true);
        dto.setUserId(publicUser.getId());
        dto.setPublicAccount(true);
        dto.setUsername(publicUser.getUsername());
        return Response.ok(dto).build();
    }
}
