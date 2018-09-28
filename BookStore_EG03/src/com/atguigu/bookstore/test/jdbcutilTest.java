package com.atguigu.bookstore.test;



import java.sql.Connection;


import com.atguigu.bookstore.utils.JDBCUtils;


import sun.management.jdp.JdpBroadcaster;

public class jdbcutilTest {
	
	
	public static void main(String[] args) {
		Connection conn = JDBCUtils.getConnection();
		//使用连接
		System.out.println(conn);
		
	}



}
