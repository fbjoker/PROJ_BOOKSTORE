package com.atguigu.bookstre.dao.impl;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstre.dao.UserDao;
import com.atguigu.bookstre.dao.baseDao;

public class UserDaoImpl extends baseDao implements UserDao {

	@Override
	public User getUserByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		String sql="select id,username,password,email "
				+ " from bs_user where username=? and password=?";
		
		return getBean(User.class,sql,user.getUsername(),user.getPassword());
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		String sql="insert into bs_user (username, password,email)values(?,?,?)";
		return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
	}

}
