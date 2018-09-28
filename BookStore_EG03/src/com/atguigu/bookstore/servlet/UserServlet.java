package com.atguigu.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService service=new UserServiceImpl();
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(null,username,password,null);
		
		request.setAttribute("errmsg", "用户名密码错误");
		
		//User userBy = dao.getUserByUsernameAndPassword(user);
		User login = service.login(user);
		
		
		if(login==null) {
			//登录失败,重新登录
			request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User(null, username, password, email);
		
		boolean regist = service.regist(user);
		if(regist) {
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else {
			request.setAttribute("errmsg", "用户名已存在");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
