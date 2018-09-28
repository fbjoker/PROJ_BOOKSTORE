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
 * Servlet implementation class RegistServlet2
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private UserDao dao=new UserDaoImpl();
	private UserService service=new UserServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		regist(request, response);
		
	}

	private void regist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
