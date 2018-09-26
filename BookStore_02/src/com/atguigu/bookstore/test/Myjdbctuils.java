package com.atguigu.bookstore.test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Myjdbctuils {
	 private static DataSource  source=null;
	 
	 static {
		 Properties properties = new Properties();
		 InputStream is = Myjdbctuils.class.getClassLoader().getSystemResourceAsStream("jdbc.properties");
		 
		 try {
			 properties.load(is);
			source=DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		 
		 
		 
	 }
	 
	 public static    Connection getCon() {
		 Connection con=null;
		 try {
			source.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return con;
	 }
	 
	 public void  closeCon(Connection con) {
		 if(con!=null) {
			 
			 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	 
	 

}
