package com.zht.util.mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {

	private static SqlSessionFactory sqlSessionFactory;
	private static String RESOURCE = "Configer.xml";
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

	static {

		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	
	/**
	 * openSession(true)//自动提交
	 * @return
	 */
	public static SqlSession getSession() {
		SqlSession session = threadLocal.get();

		if (session == null) {
			if (sqlSessionFactory == null) {
				rebuildSqlSessionFactory();
			}
			session = (sqlSessionFactory != null) ? sqlSessionFactory
					.openSession(true) : null;
			// threadLocal.set(session);
		}

		return session;
	}
	
	/**
	 * openSession(true)//自动提交
	 * @return
	 */
	public static SqlSession getSession(boolean autoCommit) {
		SqlSession session = threadLocal.get();

		if (session == null) {
			if (sqlSessionFactory == null) {
				rebuildSqlSessionFactory();
			}
			session = (sqlSessionFactory != null) ? sqlSessionFactory
					.openSession(autoCommit) : null;
			// threadLocal.set(session);
		}

		return session;
	}

	/**
	 * 重新加载
	 */
	public static void rebuildSqlSessionFactory() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
		} catch (IOException e) {
			throw new RuntimeException("Get resource error:" + RESOURCE, e);
		}

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	/**
	 * 关闭session
	 */
	public static void closeSession() {
		SqlSession session = threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}
}
