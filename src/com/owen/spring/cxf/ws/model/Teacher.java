package com.owen.spring.cxf.ws.model;

public class Teacher 
{

	public String name;
	public String address;
	public int age;
	public String phone;
	
	
	public Teacher(String name, String address, int age, String phone)
	{
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.phone = phone;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
}
