package com.owen.spring.cxf.ws.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.owen.spring.cxf.ws.model.Student;
import com.owen.spring.cxf.ws.service.StudentService;

@Component(value = "StudentService") 
@WebService(serviceName="StudentService")//与配置文件xml中的一样
public class StudentServiceImpl implements StudentService
{

	@WebResult(name="studentInfo") //返回标签的名称
	@WebMethod(operationName="getStudentInfo") //提供接口方法
	public String getStudentInfo(@WebParam(name="name") String name,@WebParam(name="age") String age) 
	{
		//创建Json对象
		JSONObject obj = new JSONObject();
		//此处为笔者固定填写信息，实际会从数据库中获取
		Student stu = new Student(name==null? "owen" : name,
				"深圳市南山区科技园",age == null? 20 : Integer.valueOf(age),"13577774444");
		//将信息封闭为json的格式
		obj.put("name",stu.getName());
		obj.put("address",stu.getAddress());
		obj.put("age", stu.getAge());
		obj.put("phone", stu.getPhone());
		
		return obj.toString();
	}

}
