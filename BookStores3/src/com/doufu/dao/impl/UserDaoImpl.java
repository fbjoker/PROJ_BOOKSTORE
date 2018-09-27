package com.doufu.dao.impl;

import com.doufu.bean.User;
import com.doufu.dao.BaseDao;
import com.doufu.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User getBean(User user) {
		String sql="select id,username,password,email from "
				+ " bs_user where username=? and password=?";
		return getBean(User.class, sql, user.getUsername(),user.getPassword());
	}

	@Override
	public int saveUser(User user) {
		String sql ="insert into bs_user (username,password,email) values(?,?,?)";
		return  updata(sql, user.getUsername(),user.getPassword(),user.getEmail());
		 
	}

}
