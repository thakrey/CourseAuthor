package com.lrn.util;

import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.BeansException; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext ctx = null;  
	 public static ApplicationContext getApplicationContext() 
	 { 
		 return ctx;  
	 }  
	 public void setApplicationContext(ApplicationContext ctx) throws BeansException { 
		 System.out.println("Setting the context");
		 this.ctx = ctx;  
	} 

}
