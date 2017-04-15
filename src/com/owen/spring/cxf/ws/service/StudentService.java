package com.owen.spring.cxf.ws.service;

/**
 * Student信息接口
 * 
 * @author Owen William 
 * @Date 2017-4-15
 *
 */
public interface StudentService 
{

	/**
	 * 获取学生信息
	 * @param name 
	 * @param age
	 * @return
	 */
	public String getStudentInfo(String name,String age);
	
	
}
