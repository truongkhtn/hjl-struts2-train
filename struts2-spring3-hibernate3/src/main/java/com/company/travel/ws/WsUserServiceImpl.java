package com.company.travel.ws;

import com.company.travel.entity.User;
import com.company.travel.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Service("wsUserService")
public class WsUserServiceImpl implements WsUserService {

    @Resource
    private UserService userService;

    public boolean userLogin(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean result = userService.login(user);
        return result;
    }
}
