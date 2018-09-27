package com.doufu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doufu.bean.User;
import com.doufu.dao.UserDao;
import com.doufu.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao usd=new UserDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(null, username, password, null);
		
		User userby = usd.getBean(user);
		
		if(userby==null) {
			response.sendRedirect("pages/user/login_success.html");
		}else {
			request.getRequestDispatcher("pages/user/login.html").forward(request, response);;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
