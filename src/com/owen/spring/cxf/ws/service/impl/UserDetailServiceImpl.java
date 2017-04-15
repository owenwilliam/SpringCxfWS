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
 * �������Ϣͨ����̨�������ݿ�����ж��Ƿ��д��û�
 * @author Owen William
 * @Date 2017-4-15
 *
 */
public class UserDetailServiceImpl implements UserDetailsService
{

	/**
	 * @param username �û����ƣ�ͨ����ݹ��������������
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		boolean userIsEnabled = true;  //�û��Ƿ���Ч
		boolean accountNonExpired = true; //�˻�û�й���
		boolean credentialsNonExpired = true;//ƾ֤û�й���
		boolean accountNonLocked = true;//�˻�û����
		
		//�˴����Զ��û�����ȥ���ݿ��ѯ�Ƿ��и��û���
		//���У����Լ�������ִ�У������ֱ�ӷ���
         List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
         authsList.add(new SimpleGrantedAuthority("admin"));
         
         //��Ȩ�޵��û����û���������SoapHeaberInterceptor������һ��
         UserDetails userdetails = new User("admin", "123456",userIsEnabled, accountNonExpired, 
        		 credentialsNonExpired, accountNonLocked, authsList);

         return userdetails;
	}

}
