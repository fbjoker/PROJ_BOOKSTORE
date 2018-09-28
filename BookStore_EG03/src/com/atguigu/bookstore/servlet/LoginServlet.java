package com.atguigu.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;
import com.atguigu.bookstre.dao.UserDao;
import com.atguigu.bookstre.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet2
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//UserDao dao=new UserDaoImpl();
	 private UserService service=new UserServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			response.sendRedirect("pages/user/login_success.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
