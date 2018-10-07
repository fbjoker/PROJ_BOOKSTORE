package com.doufu.service.impl;

import com.doufu.bean.User;
import com.doufu.dao.UserDao;
import com.doufu.dao.impl.UserDaoImpl;
import com.doufu.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud=new UserDaoImpl();

	@Override
	public User login(User user) {
//		User user2 = ud.getUser(user);
		return ud.getBean(user);
	}

	@Override
	public boolean regist(User user) {
		int saveUser = ud.saveUser(user);
		System.out.println("save");
		return saveUser>0;
	}

	@Override
	public void savaUser(User user) {
		ud.saveUser(user);
	}

}
