package com.company.travel.ws;

import com.company.travel.entity.User;
import com.company.travel.service.UserService;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import com.company.travel.ws.dto.UserLoginDTO;
import org.springframework.stereotype.Service;

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
        } else {
            output.setSuccess(false);
        }
        return Response.ok(output).build();
    }
}
