package com.company.travel.ws;

import com.company.travel.entity.User;
import com.company.travel.service.UserService;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import com.company.travel.utils.StringGenerator;
import com.company.travel.ws.dto.UserLoginDTO;
import org.springframework.stereotype.Service;

/**
 * WsUserService 接口实现类
 */
@Service("wsUserService")
public class WsUserServiceImpl implements WsUserService {

    @Resource
    private UserService userService;

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
        User user = new User();
        String random = StringGenerator.getRandomString("public", 6);
        user.setUsername(random);
        user.setPassword("");
        user.setRealname(random);
        userService.save(user);
        UserLoginDTO dto = new UserLoginDTO();
        dto.setSuccess(true);
        dto.setUserId(user.getId());
        dto.setPublicAccount(true);
        dto.setUsername(user.getUsername());
        return Response.ok(dto).build();
    }
}
