package com.atguigu.bookstore.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstre.dao.UserDao;
import com.atguigu.bookstre.dao.impl.UserDaoImpl;

public class userDaoTest {
	private UserDao dao =new UserDaoImpl();
	
	
	@Test
	public void testsave() {
		
		User user = new User(null, "test1", "9257", "33@ww");
		User ud = dao.getUserByUsernameAndPassword(user);
		System.out.println(ud);
	}
	
	
	@Test
	public void testget() {
		User user = new User(null, "test1", "9257", "33@ww");
		int saveUser = dao.saveUser(user);
		System.out.println(saveUser);
	}

}
