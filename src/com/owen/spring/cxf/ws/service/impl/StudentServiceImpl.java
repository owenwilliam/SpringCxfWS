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
@WebService(serviceName="StudentService")//�������ļ�xml�е�һ��
public class StudentServiceImpl implements StudentService
{

	@WebResult(name="studentInfo") //���ر�ǩ������
	@WebMethod(operationName="getStudentInfo") //�ṩ�ӿڷ���
	public String getStudentInfo(@WebParam(name="name") String name,@WebParam(name="age") String age) 
	{
		//����Json����
		JSONObject obj = new JSONObject();
		//�˴�Ϊ���߹̶���д��Ϣ��ʵ�ʻ�����ݿ��л�ȡ
		Student stu = new Student(name==null? "owen" : name,
				"��������ɽ���Ƽ�԰",age == null? 20 : Integer.valueOf(age),"13577774444");
		//����Ϣ���Ϊjson�ĸ�ʽ
		obj.put("name",stu.getName());
		obj.put("address",stu.getAddress());
		obj.put("age", stu.getAge());
		obj.put("phone", stu.getPhone());
		
		return obj.toString();
	}

}
