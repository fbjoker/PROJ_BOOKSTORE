package com.atguigu.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.utils.UserDao;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	UserDao ud=new UserDao();
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("zhuc");
		request.setCharacterEncoding("UTF-8");
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repwd = request.getParameter("repwd");
		String email = request.getParameter("email");
		User user = new User(null,username,password,email);
		boolean flag=ud.isIn(user);
		System.out.println(flag);
		
		if(flag) {
			response.getWriter().write("注册失败,此用户已存在");
			
		}else {
			ud.regist(user);
			request.getRequestDispatcher("pages/user/regist_success.html").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
