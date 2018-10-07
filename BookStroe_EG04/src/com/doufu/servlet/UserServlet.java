package com.doufu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doufu.bean.User;
import com.doufu.service.UserService;
import com.doufu.service.impl.UserServiceImpl;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	UserService us= new UserServiceImpl();
    
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User(null, username, password, email);
		boolean regist = us.regist(user);
		
		if(regist) {
			request.getRequestDispatcher("pages/user/regist_success.html").forward(request, response);
		}else {
			request.setAttribute("errMsg", "该用户名已注册");
			request.getRequestDispatcher("pages/user/regist.html").forward(request, response);
		}
		
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(null, username, password, null);
		User loginuser = us.login(user);
		System.out.println(loginuser);
		if(loginuser!=null){
			request.getRequestDispatcher("pages/user/login_success.html").forward(request, response);
		}else {
			request.setAttribute("errMsg", "账号密码有误");
			request.getRequestDispatcher("pages/user/login.html").forward(request, response);
		}
		
	}

}
