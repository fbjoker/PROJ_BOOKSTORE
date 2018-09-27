package com.doufu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.doufu.bean.User;
import com.doufu.util.JDBCUtils;

public class BaseDao {

	QueryRunner runner = new QueryRunner();

	public <T> T getBean(Class<T> type, String sql, Object... param) {
		Connection conn = JDBCUtils.getConnection();
		T t = null;
		try {
			t = runner.query(conn, sql, new BeanHandler<T>(type), param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(conn);
		}

		return t;
	}

	public <T> List<T> getBeanList(Class<T> type, String sql, Object... param) {
		Connection conn = JDBCUtils.getConnection();

		List<T> list = null;
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
	
	public Object getScalar(String sql,Object...param) {
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
	
	public int updata(String sql,Object...param) {
		Connection conn = JDBCUtils.getConnection();
		int update=0;
		try {
			update = runner.update(conn, sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(conn);
		}
		
		return update;
		
	}
	
	public void bathUpdata(String sql,Object[][] param) {
		
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
