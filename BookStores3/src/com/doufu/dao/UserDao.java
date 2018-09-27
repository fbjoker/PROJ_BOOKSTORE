package com.doufu.dao;

import com.doufu.bean.User;

public interface UserDao {
	
	User getBean(User user);
	int saveUser(User user);

}
