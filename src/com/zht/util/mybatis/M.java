package com.zht.util.mybatis;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


/**
 * 鏁版嵁搴撳鐞嗙被锛岀被浼间簬spring 鐨刪ibernate template
 * 瀵逛簬ORM绫诲瀷鏁版嵁搴撶殑鎿嶄綔鏍稿績绫伙紝鍚嶇О鍊熺敤浜唗hinkphp涓殑M鍑芥暟锛岀敤鏉ュ鏁版嵁搴撹繘琛岀被浼糘锛堟ā鍨嬶級绫诲瀷鐨勬搷浣�
 * 
 * @author deanchen 2014骞�鏈�0鏃�
 */
@Component
public class M implements Serializable{
	static Logger log = Logger.getLogger(M.class);
	/**
	 * 鏁版嵁搴撲笟鍔￠�杈戝疄鐜扮殑涓昏鍑芥暟锛屽弬鑰冪敤娉曪細
	 * 
	 * @param c
	 *            鏋勯�鐨勫尶鍚嶅洖璋冨嚱鏁扮被
	 */
	public void exe(C c) throws MFTException {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			c.d(session);
		} finally {
			session.close();
		}

	}
	
	/**
	 * 鐢ㄤ簬鎵ц涓嶈嚜鍔ㄦ彁浜ょ殑浜嬬墿
	 * 
	 * @param c
	 * @return
	 */
	public Object exer(CR c,boolean autoCommit) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession(autoCommit);
			return c.d(session);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return session;

	}
	
	/**
	 * 鑷涓嶈嚜鍔ㄦ彁浜ょ殑浜嬬墿
	 * @param c
	 * @param autoCommit
	 * @throws MFTException
	 */
	public void exe(C c,boolean autoCommit) throws MFTException {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession(autoCommit);
			c.d(session);
		} finally {
			session.close();
		}

	}

	/**
	 * 鍖哄埆浜巈xe鍦ㄤ簬鑳藉杩斿洖缁撴灉
	 * 
	 * @param c
	 * @return
	 */
	public Object exer(CR c) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			return c.d(session);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return session;

	}
	
	

	/**
	 * @deprecated 璇蜂娇鐢╡xe缁撳悎鍥炶皟鍑芥暟杩涜鏁版嵁搴撴搷浣滐紝鑰屼笉鏄嚜琛屼娇鐢╯ession杩涜鎿嶄綔
	 * @throws Exception
	 */
	public void getSession() throws Exception {
//		throw new Exception("涓嶅厑璁哥洿鎺ヨ幏鍙杕ybatis session锛岃鍏ㄩ儴閫氳繃exe鏂规硶杩涜鏁版嵁搴撴搷浣�);
		throw new Exception("xxx");
	}

	/**
	 * 鏍囧噯鐨刬nsert鎻掑叆鏂规硶
	 * 
	 * @param entity
	 *            瑕乮nsert鍒版暟鎹簱鐨勫疄浣�
	 * @return 鎴愬姛 or 澶辫触
	 */
	public boolean add(Object entity) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				Object mapper = session.getMapper(Class.forName(entity
						.getClass().getName() + "$Mapper"));
				Method method = mapper.getClass().getMethod("insert",
						entity.getClass());
				method.invoke(mapper, entity);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session!=null)
			  session.close();
		}
		return false;
	}

	/**
	 * 鏍囧噯鐨勬暟鎹簱瀹炰綋鏇存柊鏂规硶
	 * 
	 * @param entity
	 *            瑕佹洿鏂扮殑瀹炰綋
	 * @return 鎴愬姛 or 澶辫触
	 */
	public boolean update(Object entity) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				Object mapper = session.getMapper(Class.forName(entity
						.getClass().getName() + "$Mapper"));
				Method method = mapper.getClass().getMethod("update",
						entity.getClass());
				method.invoke(mapper, entity);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 鏍囧噯鐨勬暟鎹簱瀹炰綋鍒犻櫎鏂规硶
	 * 
	 * @param entity
	 *            瑕佸垹闄ょ殑瀹炰綋
	 * @return 鎴愬姛 or 澶辫触 0
	 */
	public boolean delete(Object entity) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				Object mapper = session.getMapper(Class.forName(entity
						.getClass().getName() + "$Mapper"));

				// TODO 杩欏効閫昏緫鏈夐棶棰橈紝杩樻病鏀瑰ソ锛屽垹闄や笉鍙敤
				Method method = mapper.getClass().getMethod("delete",
						entity.getClass());
				method.invoke(mapper, entity);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 鏍囧噯鐨勮幏鍙栧疄浣撴柟娉�
	 * 
	 * @param entityClass
	 *            瑕佽幏鍙栫殑瀹炰綋绫诲瀷
	 * @param id
	 *            瀹炰綋涓婚敭
	 * @return 瀹炰綋
	 */
	public Object get(Class<?> entityClass, int id) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				Object mapper = session.getMapper(Class.forName(entityClass
						.getName() + "$Mapper"));
				Method method = mapper.getClass().getMethod("get", int.class);
				Object result = method.invoke(mapper, id);
				return result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 灏佽浜唖qlsession鐨刧etmapper鏂规硶锛屽彲浠ョ洿鎺ヤ娇鐢ㄨ�涓嶉渶瑕佽�铏憇ession鍏抽棴绛夐棶棰�
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> type) {
		MapperProxy handler = new MapperProxy(type);
		return (T) Proxy.newProxyInstance(type.getClassLoader(),
				new Class[] { type }, handler);
	}

	public void select(String statement, Object parameter,
			ResultHandler handler) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				session.select(statement, handler);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public void select(String statement, Object parameter,
			RowBounds rowBounds, ResultHandler handler) {
		// TODO coming soon...
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				session.select(statement, rowBounds, handler);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public void select(String statement, ResultHandler handler) {
		// TODO coming soon...
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				session.select(statement, handler);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public <E> List<E> selectList(final String statement) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			return session.selectList(statement);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.toString(),ex);
			throw new MFTException(ex.toString());
		} finally {
			session.close();
		}
	}

	public <E> List<E> selectList(String statement, Object parameter) {

		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				return session.selectList(statement, parameter);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public <E> List<E> selectList(String statement, Object parameter,
			RowBounds rowBounds) {
		// TODO coming soon...
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				return session.selectList(statement, parameter, rowBounds);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public <K, V> Map<K, V> selectMap(String statement,
			Object parameter, String mapKey) {
		// TODO coming soon...
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				return session.selectMap(statement, parameter, mapKey);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public <K, V> Map<K, V> selectMap(String statement,
			Object parameter, String mapKey, RowBounds rowBounds) {
		// TODO coming soon...
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				return session.selectMap(statement, parameter, mapKey,
						rowBounds);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		// TODO coming soon...
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				return session.selectMap(statement, mapKey);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public <T> T selectOne(String statement) {
		// TODO coming soon...
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			try {
				return session.selectOne(statement);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MFTException(e.toString());
			}
		} finally {
			session.close();
		}
	}

	public <T> T selectOne(String statement, Object parameter) {
		SqlSession session = null;
		try {
			session = SessionFactory.getSession();
			return session.selectOne(statement, parameter);
		} finally {
			session.close();
		}
	}

}

class MapperProxy implements InvocationHandler {
	// private SqlSession sqlsession = null;
	private Class<?> type = null;

	public MapperProxy(Class<?> type) {
		// this.sqlsession = sqlsession;
		this.type = type;
	}

	public Object invoke(Object proxy, final Method method,
			final Object[] parames) throws Throwable {
		return new M().exer(new CR() {
			public Object d(SqlSession ss) {
				try {
					return method.invoke(ss.getMapper(type), parames);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		});

	}

}