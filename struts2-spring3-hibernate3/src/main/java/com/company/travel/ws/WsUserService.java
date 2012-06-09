package com.company.travel.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
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

    @GET
    @Path("/login/")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean userLogin(
            @FormParam("username")
            String username,
            @FormParam("password")
            String password);
}
