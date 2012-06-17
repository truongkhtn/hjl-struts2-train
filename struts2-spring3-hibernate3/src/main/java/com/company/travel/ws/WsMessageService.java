package com.company.travel.ws;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * WsMessageService 接口类
 */
@Path("/message/")
@Produces(MediaType.APPLICATION_JSON)
public interface WsMessageService {

    /**
     * 根据用户ID获取消息列表
     * @param userId  用户ID
     * @return  消息列表
     */
    @GET
    @Path("/list/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMessageById(@FormParam("id") String userId);

    /**
     * 根据msgId将消息状态改为已读
     * @param msgId  消息ID
     * @return  ok状态码
     */
    @GET
    @Path("/read/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response readMessage(@FormParam("id") String msgId);

    /**
     * 获取消息分类列表
     * @return 消息分类列表
     */
    @GET
    @Path("/category/list/")
    @Consumes(MediaType.APPLICATION_JSON )
    public Response getCategoryList();

}
