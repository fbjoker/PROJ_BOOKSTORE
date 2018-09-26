package com.atguigu.bookstore.utils;

import com.atguigu.bookstore.bean.User;

public class UserDao extends BaseDao{
	/*public static void main(String[] args) {
		 UserDao userDao = new UserDao();
		User user = new User(2,"bb","111","asdf");
		System.out.println(userDao.isIn(user));
		
		
	}*/
	
	
	public boolean isIn(User user) {
		String username = user.getUsername();
		String sql="select * from bs_user where username=?";
		User bean = getBean(User.class, sql, username);
		if(bean==null) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public void regist(User user) {
		String sql="INSERT INTO bs_user VALUES(NULL,?,?,?)";
		update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}
	
	public boolean login(String name,String pwd) {
		String sql="select * from bs_user where username=? and password=?";
		User bean = getBean(User.class, sql, name,pwd);
		
		if(bean==null) {
			return false;
		}else {
			return true;
		}
		
		
	}

}
