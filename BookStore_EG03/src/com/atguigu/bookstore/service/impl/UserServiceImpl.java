package com.atguigu.bookstore.service.impl;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstre.dao.UserDao;
import com.atguigu.bookstre.dao.impl.UserDaoImpl;

public class UserServiceImpl implements UserService {

	
	 private UserDao  dao=new UserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return dao.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		int i=dao.saveUser(user);
		
		return i>0;
	}

}
