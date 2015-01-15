package cn.edu.bjtu.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class SpringBeanFactory {
	
	public static Object getInstance(String beanId)
	{
		ApplicationContext context=new XmlWebApplicationContext();
		
		return context.getBean(beanId);
	}

}
