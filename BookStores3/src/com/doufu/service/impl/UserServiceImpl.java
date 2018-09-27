package com.doufu.service.impl;

import com.doufu.bean.User;
import com.doufu.dao.UserDao;
import com.doufu.dao.impl.UserDaoImpl;
import com.doufu.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao usd=new UserDaoImpl();

	@Override
	public User login(User user) {
		
		return usd.getBean(user);
	}

	@Override
	public boolean regist(User user) {
		int saveUser = usd.saveUser(user);
		return saveUser>0;
	}

}
