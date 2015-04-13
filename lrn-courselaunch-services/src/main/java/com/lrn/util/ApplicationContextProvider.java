package com.lrn.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
   
/**  
* The Class ApplicationContextProvider
* 
* 
*/
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