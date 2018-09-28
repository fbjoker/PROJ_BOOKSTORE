package com.atguigu.bookstore.service;

import com.atguigu.bookstore.bean.User;

public interface UserService {
	
	User login(User user);
	
	boolean regist(User user);

}
