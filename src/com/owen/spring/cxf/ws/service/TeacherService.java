package com.owen.spring.cxf.ws.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface TeacherService 
{
    
	  
    @GET
    @Path("/init/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeacherInfo(@PathParam("name")String name,@PathParam("age")String age);
}
