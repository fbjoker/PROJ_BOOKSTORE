package com.atguigu.bookstre.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.bookstore.utils.JDBCUtils;

public class baseDao {
	
	 private QueryRunner runner= new QueryRunner();
	 
	 
	 
	 public int update(String sql, Object...param ) {
		 Connection conn = JDBCUtils.getConnection();
		 
		 int i=0;
		 try {
			i=runner.update(conn, sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				JDBCUtils.closeConnection(conn);
			
		}
		 
		 return i;
		 
	 }

	 public <T>T getBean(Class<T> type,String sql,Object...param) {
		 Connection conn = JDBCUtils.getConnection();
		 
		 T t=null;
		 try {
			 t= runner.query(conn, sql, new BeanHandler<T>(type), param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn);
		}
		 //NULL表示查询失败,
		return t;
	 }
	 
	 
	 public <T> List<T>  getBeanList(Class<T> type, String sql, Object...param) {
		 Connection conn = JDBCUtils.getConnection();
		 List<T> list =null;
		 try {
			 list = runner.query(conn,sql, new BeanListHandler<T>(type),  param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn);
		}
		 
		 return list;
	 }
	 
	 
	 public Object  getScalar(String sql, Object...param) {
		 
		 Connection conn = JDBCUtils.getConnection();
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
	 
	 //批量增删改
	 public void batchUpdate(String sql,Object[][] param) {
		 Connection conn = JDBCUtils.getConnection();
		 try {
			runner.batch(conn, sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn);
		}
	 }
	 
}
