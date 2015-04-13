
package com.lrn.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter{
 
    private static final Logger logger = Logger.getLogger("interceptor");
 
    //before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request, 
        HttpServletResponse response, Object handler)
        throws Exception {
 
    	String user = request.getHeader("user");
    	System.out.println("user>>> " + user);
    	String password = request.getHeader("password");
    	System.out.println("password>>> " + password);
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        logger.debug("[ ExecuteTimeInterceptor PreHandle ]");
        System.out.println("[ 11ExecuteTimeInterceptor PreHandle ]");
        Enumeration headerNames = request.getHeaderNames();
        System.out.println("headerNames   kk >>> " + headerNames);
        System.out.println("headerNames>>> " + headerNames);
        
        request.getAttributeNames();
        
//        while(request.getAttributeNames().hasMoreElements()){
//
//            System.out.println("request keys >>> " + request.getAttributeNames().nextElement());
//        }
        
        String ipAddress = request.getHeader("Remote_Addr");
        System.out.println("ipAddress>>>> " + ipAddress);
        String ipAddress2 = request.getHeader("HTTP_X_FORWARDED_FOR");

        if (ipAddress2 == null) {
        	ipAddress2 = request.getRemoteAddr();
        }
        System.out.println("ipAddress2>>>> " + ipAddress2);
        while(headerNames.hasMoreElements()){

        System.out.println("header keys >>> " + headerNames.nextElement());
        }
        return true;
    }
 
    //after the handler is executed
    public void postHandle(
        HttpServletRequest request, HttpServletResponse response, 
        Object handler, ModelAndView modelAndView)
        throws Exception {
 
        long startTime = (Long)request.getAttribute("startTime");
 
        long endTime = System.currentTimeMillis();
 
        long executeTime = endTime - startTime;
 
        //modified the exisitng modelAndView
        //modelAndView.addObject("executeTime",executeTime);
 
        //log it
        System.out.println("[" + handler + "] executeTime : " + executeTime + "ms");
        if(logger.isDebugEnabled()){
           logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
        }
    }
}