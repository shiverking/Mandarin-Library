package dao;
/**
* @author 
* @version é”Ÿæ–¤æ‹·é”Ÿæ–¤æ‹·æ—¶é”Ÿæˆ’ï¼š2019é”Ÿæ–¤æ‹·9é”Ÿæ–¤æ‹·23é”Ÿæ–¤æ‹· é”Ÿæ–¤æ‹·é”Ÿæ–¤æ‹·1:57:18
* 
*/

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.HibernateException;

public abstract class BaseDaoImpl<TEntity> implements BaseDao<TEntity> {

	private SessionFactory sf;
	private Class<TEntity> entityClass;

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	protected Session getSession() {
		return sf.openSession();
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Class<?> c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) t).getActualTypeArguments();
			entityClass = (Class<TEntity>) types[0];
		}
	}

	public void save(TEntity entity) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void merge(TEntity entity) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(entity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(TEntity entity) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	public void deleteByLS(int id) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TEntity entity = (TEntity) session.get(entityClass, id);
			session.delete(entity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void delete(int id) {
		TEntity entity = get(id);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<TEntity> findAll(String cond) {
		if (cond != null) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		List<TEntity> entities = this.getSession().createQuery("from " + entityClass.getSimpleName() + cond).list();
		return entities;
	}

	public List<TEntity> findAll() {
		return this.findAll(null);
	}

	public List<TEntity> findBy(String propertyName, Object propertyValue, String cond) {
		if (cond != null) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName + "=:propertyValue" + cond;
		Query query = this.getSession().createQuery(queryString);
		List<TEntity> entities = query.setParameter("propertyValue", propertyValue).list();
		return entities;
	}

	public List<TEntity> findBy(String propertyName, Object propertyValue) {
		return findBy(propertyName, propertyValue, null);
	}

	public List<TEntity> findBySubString(String propertyName, String cond) {

		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName + " like '%" + cond + "%'";
		List<TEntity> entities = this.getSession().createQuery(queryString).list();
		return entities;
	}

	@SuppressWarnings("unchecked")
	public TEntity get(int id) {
		Session session = this.getSession();
		session.beginTransaction();
		TEntity entity = (TEntity) session.get(entityClass, id);
		session.getTransaction().commit();
		session.close();
		return entity;
	}

	public TEntity getSingle(String propertyName, Object propertyValue) {
		List<TEntity> entities = findBy(propertyName, propertyValue);
		if (entities != null && entities.size() > 0) {
			return entities.get(0);
		}
		return null;
	}

<<<<<<< HEAD
	// é”Ÿæ–¤æ‹·å±•é”Ÿä¾¥è®¹æ‹·é”Ÿæ–¤æ‹·é”Ÿæ·åŒ¡æ‹·åŒé”Ÿæ–¤æ‹·é”Ÿçš†è¯§æ‹·è¯¢
=======
>>>>>>> wjy
	public List<TEntity> findByTwoProperty(String propertyName1, String propertyName2, String cond1) {
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + " like '%" + cond1 + "%'" + " or e." + propertyName2 + " like '%"
				+ cond1 + "%'";
		List<TEntity> entities = this.getSession().createQuery(queryString).list();
		return entities;
	}

<<<<<<< HEAD
//é”Ÿæ–¤æ‹·å±•é”Ÿæ–¤æ‹·IDé”Ÿæ–¤æ‹·é”Ÿæ–¤æ‹·é”Ÿçª–ï¿½
=======
//ï¿½ï¿½Õ¹ï¿½ï¿½IDï¿½ï¿½ï¿½ï¿½ï¿½Ñ¯
>>>>>>> wjy
	public List<TEntity> findByIDList(List<Integer> IDlist) {

		String namString = entityClass.getSimpleName();
		if (entityClass.getSimpleName().equals("Borrowrecord"))
			namString = "record";
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + namString + "ID IN (:IDlist)";
		Query query = this.getSession().createQuery(queryString);
		List<TEntity> list = query.setParameterList("IDlist", IDlist).list();

		return list;
	}

<<<<<<< HEAD
	// é”Ÿæ–¤æ‹·é¡µé”Ÿæ–¤æ‹·è¯¢å®žé”Ÿæ–¤æ‹·
=======
	// ï¿½ï¿½Ò³ï¿½ï¿½Ñ¯Êµï¿½ï¿½
>>>>>>> wjy
	public int findTotalNum(String propertyName, Object propertyValue) {
		String namString = entityClass.getSimpleName();
		if (entityClass.getSimpleName().equals("Borrowrecord"))
			namString = "record";
		String queryString = "SELECT COUNT(" + namString + "ID) from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName + "=:propertyValue";
		Query query = this.getSession().createQuery(queryString);
		List<Long> list = query.setParameter("propertyValue", propertyValue).list();
		return list.isEmpty() ? 0 : list.get(0).intValue();
	}

	public List<TEntity> findPageByQuery(String propertyName, Object propertyValue, String cond, int pageStart,
			int pageSize) {
		if (cond != null && !cond.isEmpty()) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName + "=:propertyValue" + cond;
		Query query = this.getSession().createQuery(queryString);
		query.setParameter("propertyValue", propertyValue);
		query.setFirstResult(pageStart);
		query.setMaxResults(pageSize);
		List<TEntity> results = query.list();
		return results;
	}

//Ë«ÊôÐÔ·ÖÒ³µ¥ÖµÄ£ºý²éÑ¯
	public int findTotalNumbyTwoSubstring(String propertyName1, String propertyName2, String cond1) {
<<<<<<< HEAD
		// TODO:é”Ÿæ–¤æ‹·é¡µé”Ÿæ–¤æ‹·é”Ÿæ–¤æ‹·
=======
		// TODO:ï¿½ï¿½Ò³ï¿½ï¿½ï¿½ï¿½
>>>>>>> wjy
		String namString = entityClass.getSimpleName();
		if (entityClass.getSimpleName().equals("Borrowrecord"))
			namString = "record";
		if (cond1 == null) {
			cond1 = "";
		}
		String queryString = "SELECT COUNT(" + namString + "ID) from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + " like '%" + cond1 + "%'" + " or e." + propertyName2 + " like '%"
				+ cond1 + "%'";
		Query query = this.getSession().createQuery(queryString);
		List<Long> list = query.list();
		return list.isEmpty() ? 0 : list.get(0).intValue();
	}

	public List<TEntity> findPageByTwoSubstring(String propertyName1, String propertyName2, String cond1, String cond2,
			int pageStart, int pageSize) {
		// TODO:é”Ÿæ–¤æ‹·é¡µé”Ÿæ–¤æ‹·é”Ÿæ–¤æ‹·
		if (cond1 == null) {
			cond1 = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + " like '%" + cond1 + "%'" + " or e." + propertyName2 + " like '%"
				+ cond2 + "%'";
		Query query = this.getSession().createQuery(queryString);
		query.setFirstResult(pageStart);
		query.setMaxResults(pageSize);
		List<TEntity> results = query.list();
		return results;
	}

<<<<<<< HEAD
	// åŒé”Ÿæ–¤æ‹·é”Ÿçš†æ’…æ‹·å‡†é”Ÿæ–¤æ‹·è¯¢å®žé”Ÿæ–¤æ‹·
=======
	// Ë«ï¿½ï¿½ï¿½Ô¾ï¿½×¼ï¿½ï¿½Ñ¯Êµï¿½ï¿½
>>>>>>> wjy
	public List<TEntity> getByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2) {
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + "=:Value1" + " and e." + propertyName2 + "=:Value2";
		Query query = this.getSession().createQuery(queryString);
		query.setParameter("Value1", Value1);
		query.setParameter("Value2", Value2);
		return query.list();
	}

	//
	public int findTotalNumbyTwoProperty(String propertyName1, String propertyName2, Object value1, Object value2) {
		String namString = entityClass.getSimpleName();
		if (entityClass.getSimpleName().equals("Borrowrecord"))
			namString = "record";
		String queryString = "SELECT COUNT(" + namString + "ID) from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + "=:Value1" + " and e." + propertyName2 + "=:Value2";
		Query query = this.getSession().createQuery(queryString);
		query.setParameter("Value1", value1);
		query.setParameter("Value2", value2);
		List<Long> list = query.list();
		return list.isEmpty() ? 0 : list.get(0).intValue();
	}
<<<<<<< HEAD
	//
	public List<TEntity> findPageByTwoProperty(String propertyName1,String propertyName2, Object Value1, Object Value2, String cond, int pageStart, int pageSize){
=======

	//
	public List<TEntity> getPageByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2,
			String cond, int pageStart, int pageSize) {
>>>>>>> wjy
		if (cond != null) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
<<<<<<< HEAD
		queryString += "where e." + propertyName1 + "=:Value1" +" and e." + propertyName2 + "=:Value2"+ cond;
=======
		queryString += "where e." + propertyName1 + "=:Value1" + " and e." + propertyName2 + "=:Value2" + cond;
>>>>>>> wjy
		Query query = this.getSession().createQuery(queryString);
		query.setParameter("Value1", Value1);
		query.setParameter("Value2", Value2);
		query.setFirstResult(pageStart);
		query.setMaxResults(pageSize);
		List<TEntity> results = query.list();
		return results;
	}
<<<<<<< HEAD
	//ç’‡è¯²å½‡ç’‡æ˜ï¿½å‘®æšŸé©ï¿½
=======
	//è¯»å–è¯»è€…æ•°ç›®
>>>>>>> wjy
		public int numOfReader() {
			String queryString = "select count(*) from " + entityClass.getSimpleName() + " e ";
			Query query = this.getSession().createQuery(queryString);
			List<Long> list = query.list();
			return list.isEmpty() ? 0 : list.get(0).intValue();
		}
<<<<<<< HEAD
=======

	// TODO:ÍòÄÜµÄ·ÖÒ³²éÑ¯£¬º­¸ÇËùÓÐ·ÖÒ³²éÑ¯·½Ê½
	public Integer findTotalNum(List<String> propertyName, List<String> value, Integer andEnd, Integer equalEnd) {
		String namString = entityClass.getSimpleName();
		if (entityClass.getSimpleName().equals("Borrowrecord"))
			namString = "record";
		String queryString = "SELECT COUNT(" + namString + "ID) from " + entityClass.getSimpleName() + " e where ";
		int i = 0;
		for (; i < andEnd; i++) {// ÏÈÌí¼ÓandÌõ¼þ
			if (i > 0)
				queryString += " and ";// ÈôandÌõ¼þ¸öÊý´óÓÚ1¸ö£¬Ìí¼Óand¹Ø¼ü´Ê
			if (i < equalEnd) {// ¸ù¾ÝequalEnd¾ö¶¨´ËÊôÐÔÊÇ¾«×¼²éÑ¯»¹ÊÇÄ£ºý²éÑ¯
				queryString += " e." + propertyName.get(i) + "=" + value.get(i);
			} else {
				queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
			}
		}
		if (i < propertyName.size()) {
			if (i > 0) {
				queryString += " and ";// Èç¹ûÇ°ÃæÓÐandÌõ¼þ£¬ÏÈÌí¼Óand¹Ø¼ü´Ê
			}
			queryString += "(";
			for (; i < propertyName.size(); i++) {// Ìí¼ÓorÌõ¼þ
				if (i > andEnd) {
					queryString += " or ";// Èç¹ûorÌõ¼þ¸öÊý´óÓÚ1¸ö£¬Ìí¼Óor¹Ø¼ü´Ê
				}
				if (i < equalEnd) {// ¸ù¾ÝequalEnd¾ö¶¨´ËÊôÐÔÊÇ¾«×¼²éÑ¯»¹ÊÇÄ£ºý²éÑ¯
					queryString += " e." + propertyName.get(i) + "=" + value.get(i);
				} else {
					queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
				}
			}
			queryString += "" + ")";
		}
		Query query = this.getSession().createQuery(queryString);
		List<Long> list = query.list();
		return list.isEmpty() ? 0 : list.get(0).intValue();
	}

	// TODO:ÍòÄÜµÄ·ÖÒ³²éÑ¯£¬º­¸ÇËùÓÐ·ÖÒ³²éÑ¯·½Ê½
	public List<TEntity> findPage(List<String> propertyName, List<String> value, List<String> order, Integer andEnd,
			Integer equalEnd, Integer desWhen, int pageStart, int pageSize) {
		String queryString = " from " + entityClass.getSimpleName() + " e where ";
		int i = 0;
		// Ìí¼Ó²éÑ¯Ìõ¼þ
		for (; i < andEnd; i++) {// ÏÈÌí¼ÓandÌõ¼þ
			if (i > 0)
				queryString += " and ";// ÈôandÌõ¼þ¸öÊý´óÓÚ1¸ö£¬Ìí¼Óand¹Ø¼ü´Ê
			if (i < equalEnd) {// ¸ù¾ÝequalEnd¾ö¶¨´ËÊôÐÔÊÇ¾«×¼²éÑ¯»¹ÊÇÄ£ºý²éÑ¯
				queryString += " e." + propertyName.get(i) + "=" + value.get(i);
			} else {
				queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
			}
		}
		if (i < propertyName.size()) {
			if (i > 0) {
				queryString += " and ";// Èç¹ûÇ°ÃæÓÐandÌõ¼þ£¬ÏÈÌí¼Óand¹Ø¼ü´Ê
			}
			queryString += "(";
			for (; i < propertyName.size(); i++) {// Ìí¼ÓorÌõ¼þ
				if (i > andEnd) {
					queryString += " or ";// Èç¹ûorÌõ¼þ¸öÊý´óÓÚ1¸ö£¬Ìí¼Óor¹Ø¼ü´Ê
				}
				if (i < equalEnd) {// ¸ù¾ÝequalEnd¾ö¶¨´ËÊôÐÔÊÇ¾«×¼²éÑ¯»¹ÊÇÄ£ºý²éÑ¯
					queryString += " e." + propertyName.get(i) + "=" + value.get(i);
				} else {
					queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
				}
			}
			queryString += "" + ")";
		}
		// Èôorder²»Îª¿Õ£¬Ìí¼ÓÅÅÐòÌõ¼þ
		if (order != null && !order.isEmpty()) {
			queryString += " order by ";
			for (int j = 0; j < order.size(); j++) {
				queryString += order.get(j);
				if (j + 1 < order.size()) {
					queryString += ",";
				}
			}
		}
		Query query = this.getSession().createQuery(queryString);
		query.setFirstResult(pageStart);
		query.setMaxResults(pageSize);
		List<TEntity> results = query.list();
		return results;
	}

	// TODO:»ñÈ¡µ¥Ò»×Ö¶ÎµÄ²éÑ¯.½öÖ§³Ö×Ö·û´®
	public List<String> findSingleField(List<String> propertyName, List<String> value, String name, Integer andEnd,
			Integer equalEnd) {
		String queryString = "select "+name+" from " + entityClass.getSimpleName() + " e where ";
		int i = 0;
		// Ìí¼Ó²éÑ¯Ìõ¼þ
		for (; i < andEnd; i++) {// ÏÈÌí¼ÓandÌõ¼þ
			if (i > 0)
				queryString += " and ";// ÈôandÌõ¼þ¸öÊý´óÓÚ1¸ö£¬Ìí¼Óand¹Ø¼ü´Ê
			if (i < equalEnd) {// ¸ù¾ÝequalEnd¾ö¶¨´ËÊôÐÔÊÇ¾«×¼²éÑ¯»¹ÊÇÄ£ºý²éÑ¯
				queryString += " e." + propertyName.get(i) + "=" + value.get(i);
			} else {
				queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
			}
		}
		if (i < propertyName.size()) {
			if (i > 0) {
				queryString += " and ";// Èç¹ûÇ°ÃæÓÐandÌõ¼þ£¬ÏÈÌí¼Óand¹Ø¼ü´Ê
			}
			queryString += "(";
			for (; i < propertyName.size(); i++) {// Ìí¼ÓorÌõ¼þ
				if (i > andEnd) {
					queryString += " or ";// Èç¹ûorÌõ¼þ¸öÊý´óÓÚ1¸ö£¬Ìí¼Óor¹Ø¼ü´Ê
				}
				if (i < equalEnd) {// ¸ù¾ÝequalEnd¾ö¶¨´ËÊôÐÔÊÇ¾«×¼²éÑ¯»¹ÊÇÄ£ºý²éÑ¯
					queryString += " e." + propertyName.get(i) + "=" + value.get(i);
				} else {
					queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
				}
			}
			queryString += "" + ")";
		}
		Query query = this.getSession().createQuery(queryString);
		List<String> list = query.list();
		return list;
	}
>>>>>>> wjy
}
