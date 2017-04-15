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
 * ��������
 *      ���û�����ϢȨ�޽�����֤
 * @author Owen William
 * @Date 2017-4-15
 *
 */
@Component(value="readSoapHeader")
public class SoapHeaderInterceptor  extends AbstractPhaseInterceptor<SoapMessage>
{

	//Ȩ�޹���
	 @Autowired(required=false)
	 private AuthenticationManager authenticationManager;
	
	public SoapHeaderInterceptor() 
	{
		super(Phase.PRE_PROTOCOL);
		//���SAAJInterceptor������
        getAfter().add(SAAJInInterceptor.class.getName());
	}

	/**
	 * @param meaasge ��Ϣͷ��Ϣ
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault 
	{
		//�����û��������룬�����û�����Ϣ��������߽���д�̶���ʵ�ʿ���д�������ļ���ӷ����ߵ���Ϣ����ȡ
		UsernamePasswordAuthenticationToken adminAuth = new UsernamePasswordAuthenticationToken("admin","123456");
		//�������Ϣ����
		Authentication authenticatedUser = authenticationManager.authenticate(adminAuth); 
		//�����Ϣ��Ҫ��һ��ȥ��̨���ݿ�����ж��Ƿ���ȷ
		//�����������У��ͻ�ȥ����UserDetailsService������һ���ж�
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		
	}

}
