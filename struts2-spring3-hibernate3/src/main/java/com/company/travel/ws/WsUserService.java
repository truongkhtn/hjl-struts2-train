package com.company.travel.ws;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * WsUserService 接口类
 *
 * The interface exposed as soap and rest
 *
 * @ Path is for the rest top path, ,should be the same as cxf-config.xml
 * @ GET/POST/PUT/DELETE is for REST
 * @ Path is for the REST service path
 * @ PathParam is for REST parameter in url
 * @ FormParam is for REST parameter in form
 * @ Produces is marked for response type
 */

@Path("/user/")
@Produces(MediaType.APPLICATION_JSON)
public interface WsUserService {

    /**
     * 用户登陆验证方法
     * @param username 用户名
     * @param password 密码
     * @return 是否登陆成功
     */
    @GET
    @Path("/login/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response userLogin(
            @FormParam("username")
            String username,
            @FormParam("password")
            String password);

    /**
     * 注册public账号
     * @return 随机账号
     */
    @GET
    @Path("/register/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register();


}
