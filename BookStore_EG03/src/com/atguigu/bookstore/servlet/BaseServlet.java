package com.atguigu.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String type = request.getParameter("type");
		if("login".equals(type)) {
			login(request, response);
		}else if("regist".equals(type)) {
			regist(request, response);
		}*/
		
		//获取调用doget方法的类的类型
		//在doGet方法中 通过反射调用子类的type对应的方法
		
		
		Class clazz = this.getClass();
		
		System.out.println(clazz);
		System.out.println(clazz.getName());
		//获取方法名
		String type = request.getParameter("type");
		//
		try {
			Method method=clazz.getDeclaredMethod(type,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
