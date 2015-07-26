package com.zht.util.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * 数据库处理类回调函数类，类似于spring 的hibernate template 中的回调函数
 * 虽然提倡完整的变量名称写法，但是这里使用了简单的变量、类名（如C），是因为考虑数据层访问非常频繁，
 * 所以用简单的名称节约调用时的代码量
 * @author deanchen
 * 2014年3月30日
 */
public interface C {
	/**
	 * 回调函数，实际上就在这里写所有的数据库处理逻辑，注意，所有这里面用到的外部变量
	 * 必须申明为final，这一点现在看好像还没有造成太多的困扰
	 * @param ss SqlSession
	 */
	public void d(SqlSession ss);
}
