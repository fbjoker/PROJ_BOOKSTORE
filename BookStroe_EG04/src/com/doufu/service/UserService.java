package com.doufu.service;

import com.doufu.bean.User;

public interface UserService {
	User login(User user);
	boolean regist(User user);
	void savaUser(User user);

}
