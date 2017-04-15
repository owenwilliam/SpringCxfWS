package com.owen.spring.cxf.ws.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
/**
 * 拦截器：
 *      对用户的信息权限进行验证
 * @author Owen William
 * @Date 2017-4-15
 *
 */
@Component(value="readSoapHeader")
public class SoapHeaderInterceptor  extends AbstractPhaseInterceptor<SoapMessage>
{

	//权限管理
	 @Autowired(required=false)
	 private AuthenticationManager authenticationManager;
	
	public SoapHeaderInterceptor() 
	{
		super(Phase.PRE_PROTOCOL);
		//添加SAAJInterceptor拦截器
        getAfter().add(SAAJInInterceptor.class.getName());
	}

	/**
	 * @param meaasge 消息头信息
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault 
	{
		//输入用户名与密码，代表用户的信息。这里笔者将其写固定，实际可以写在配置文件或从访问者的信息中提取
		UsernamePasswordAuthenticationToken adminAuth = new UsernamePasswordAuthenticationToken("admin","123456");
		//对身份信息管理
		Authentication authenticatedUser = authenticationManager.authenticate(adminAuth); 
		//身份信息需要进一步去后台数据库进行判断是否正确
		//放入上下文中，就会去调用UserDetailsService，做进一步判断
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		
	}

}
