package com.owen.spring.cxf.ws.service;

/**
 * Student��Ϣ�ӿ�
 * 
 * @author Owen William 
 * @Date 2017-4-15
 *
 */
public interface StudentService 
{

	/**
	 * ��ȡѧ����Ϣ
	 * @param name 
	 * @param age
	 * @return
	 */
	public String getStudentInfo(String name,String age);
	
	
}
