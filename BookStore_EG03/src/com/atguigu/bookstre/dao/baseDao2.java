package com.atguigu.bookstre.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.bookstore.utils.JDBCUtils;

public class baseDao2 {
	QueryRunner runner=new QueryRunner();
	
	
	
	public int update(String sql,Object...param) {
		Connection conn = JDBCUtils.getConnection();
		int i=0;
		try {
			i=runner.update(conn, sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn);
		}
		
		return i;
	}
	
	
	
	
	public <T> T getBean(Class<T> type,String sql,Object...param) {
		Connection conn = JDBCUtils.getConnection();
		T t=null; 
		
		try {
			t = runner.query(conn, sql, new BeanHandler<T>(type), param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn);
		}
		
		
		return t;
		
	}
	
	public <T> List<T> getListBean(Class<T> type,String sql,Object...param) {
		Connection conn = JDBCUtils.getConnection();
		List<T> list=null;
		 try {
			list = runner.query(conn, sql, new BeanListHandler<>(type), param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn);
		}
		 
		return list;
	}
	
	public Object getobj(String sql,Object...param) {
		Connection conn = JDBCUtils.getConnection();
		//Object obj=null;
		Object obj=null;
		try {
			obj = runner.query(conn, sql, new ScalarHandler(), param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn);
		}
		
		
		return obj;
		
		
		
	}
	
	

}
