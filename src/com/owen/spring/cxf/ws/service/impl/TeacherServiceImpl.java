package com.owen.spring.cxf.ws.service.impl;


import javax.jws.WebResult;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.owen.spring.cxf.ws.model.Teacher;
import com.owen.spring.cxf.ws.service.TeacherService;

@Path(value = "/")
public class TeacherServiceImpl implements TeacherService
{

	
	@GET
    @Path("/getTeacherInfo/{name}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
	public String getTeacherInfo(@PathParam("name") String name,@PathParam("age") String age) 
	{
		//创建Json对象
		JSONObject obj = new JSONObject();
		//此处为笔者固定填写信息，实际会从数据库中获取
		Teacher teacher = new Teacher(name==null? "william" : name,
				"深圳市福田区会展中心",age == null? 20 : Integer.valueOf(age),"13533334444");
		//将信息封闭为json的格式
		obj.put("name",teacher.getName());
		obj.put("address",teacher.getAddress());
		obj.put("age", teacher.getAge());
		obj.put("phone", teacher.getPhone());
				
		return obj.toString();
	}

}
