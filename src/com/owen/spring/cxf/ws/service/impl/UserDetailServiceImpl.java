package com.owen.spring.cxf.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 将身份信息通过后台，即数据库进行判断是否有此用户
 * @author Owen William
 * @Date 2017-4-15
 *
 */
public class UserDetailServiceImpl implements UserDetailsService
{

	/**
	 * @param username 用户名称，通过身份管理的上下文中拿
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		boolean userIsEnabled = true;  //用户是否有效
		boolean accountNonExpired = true; //账户没有过期
		boolean credentialsNonExpired = true;//凭证没有过期
		boolean accountNonLocked = true;//账户没有锁
		
		//此处可以对用户名，去数据库查询是否有该用户，
		//如有，可以继续向下执行，否则就直接返回
         List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
         authsList.add(new SimpleGrantedAuthority("admin"));
         
         //有权限的用户，用户与密码与SoapHeaberInterceptor中配置一致
         UserDetails userdetails = new User("admin", "123456",userIsEnabled, accountNonExpired, 
        		 credentialsNonExpired, accountNonLocked, authsList);

         return userdetails;
	}

}
