package com.doufu.test;

import java.sql.Connection;

import com.doufu.util.JDBCUtils;

public class JDBCUtilTest {
	
	public static void main(String[] args) {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
	}

}
