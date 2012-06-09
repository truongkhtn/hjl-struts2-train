package com.company.travel.ws;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Author: Hu jing ling
 * Date: 12-6-10
 * Description: put description for the type here...
 */
@Path("/message/")
@Produces(MediaType.APPLICATION_JSON)
public interface WsMessageService {

    /**
     * 根据用户 ID 获得未读消息列表
     * @param username
     * @param password
     * @return
     */
    @GET
    @Path("/login/")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean getUnreadMessageById(
            @FormParam("username")
            String username,
            @FormParam("password")
            String password);

}
