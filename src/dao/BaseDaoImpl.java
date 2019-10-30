package dao;
/**
* @author 
* @version 锟斤拷锟斤拷时锟戒：2019锟斤拷9锟斤拷23锟斤拷 锟斤拷锟斤拷1:57:18
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

	public List<TEntity> findByTwoProperty(String propertyName1, String propertyName2, String cond1) {
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + " like '%" + cond1 + "%'" + " or e." + propertyName2 + " like '%"
				+ cond1 + "%'";
		List<TEntity> entities = this.getSession().createQuery(queryString).list();
		return entities;
	}

//锟斤拷展锟斤拷ID锟斤拷锟斤拷锟窖�
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

	// 锟斤拷页锟斤拷询实锟斤拷
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

//双属性分页单值模糊查询
	public int findTotalNumbyTwoSubstring(String propertyName1, String propertyName2, String cond1) {
		// TODO:锟斤拷页锟斤拷锟斤拷
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

	public List<TEntity> findPageByTwoProperty(String propertyName1, String propertyName2, String cond1, int pageStart,
			int pageSize) {
		// TODO:分页搜索
		if (cond1 == null) {
			cond1 = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + " like '%" + cond1 + "%'" + " or e." + propertyName2 + " like '%"
				+ cond1 + "%'";
		Query query = this.getSession().createQuery(queryString);
		query.setFirstResult(pageStart);
		query.setMaxResults(pageSize);
		List<TEntity> results = query.list();
		return results;
	}

	// 双锟斤拷锟皆撅拷准锟斤拷询实锟斤拷
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

	//
	public List<TEntity> getPageByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2,
			String cond, int pageStart, int pageSize) {
		if (cond != null) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + "=:Value1" + " and e." + propertyName2 + "=:Value2" + cond;
		Query query = this.getSession().createQuery(queryString);
		query.setParameter("Value1", Value1);
		query.setParameter("Value2", Value2);
		query.setFirstResult(pageStart);
		query.setMaxResults(pageSize);
		List<TEntity> results = query.list();
		return results;
	}
	//璇诲潠璇昏�呮暟鐩�
		public int numOfReader() {
			String queryString = "select count(*) from " + entityClass.getSimpleName() + " e ";
			Query query = this.getSession().createQuery(queryString);
			List<Long> list = query.list();
			return list.isEmpty() ? 0 : list.get(0).intValue();
		}

	// TODO:万能的分页查询，涵盖所有分页查询方式
	public Integer findTotalNum(List<String> propertyName, List<String> value, Integer andEnd, Integer equalEnd) {
		String namString = entityClass.getSimpleName();
		if (entityClass.getSimpleName().equals("Borrowrecord"))
			namString = "record";
		String queryString = "SELECT COUNT(" + namString + "ID) from " + entityClass.getSimpleName() + " e where ";
		int i = 0;
		for (; i < andEnd; i++) {// 先添加and条件
			if (i > 0)
				queryString += " and ";// 若and条件个数大于1个，添加and关键词
			if (i < equalEnd) {// 根据equalEnd决定此属性是精准查询还是模糊查询
				queryString += " e." + propertyName.get(i) + "=" + value.get(i);
			} else {
				queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
			}
		}
		if (i < propertyName.size()) {
			if (i > 0) {
				queryString += " and ";// 如果前面有and条件，先添加and关键词
			}
			queryString += "(";
			for (; i < propertyName.size(); i++) {// 添加or条件
				if (i > andEnd) {
					queryString += " or ";// 如果or条件个数大于1个，添加or关键词
				}
				if (i < equalEnd) {// 根据equalEnd决定此属性是精准查询还是模糊查询
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

	// TODO:万能的分页查询，涵盖所有分页查询方式
	public List<TEntity> findPage(List<String> propertyName, List<String> value, List<String> order, Integer andEnd,
			Integer equalEnd, Integer desWhen, int pageStart, int pageSize) {
		String queryString = " from " + entityClass.getSimpleName() + " e where ";
		int i = 0;
		// 添加查询条件
		for (; i < andEnd; i++) {// 先添加and条件
			if (i > 0)
				queryString += " and ";// 若and条件个数大于1个，添加and关键词
			if (i < equalEnd) {// 根据equalEnd决定此属性是精准查询还是模糊查询
				queryString += " e." + propertyName.get(i) + "=" + value.get(i);
			} else {
				queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
			}
		}
		if (i < propertyName.size()) {
			if (i > 0) {
				queryString += " and ";// 如果前面有and条件，先添加and关键词
			}
			queryString += "(";
			for (; i < propertyName.size(); i++) {// 添加or条件
				if (i > andEnd) {
					queryString += " or ";// 如果or条件个数大于1个，添加or关键词
				}
				if (i < equalEnd) {// 根据equalEnd决定此属性是精准查询还是模糊查询
					queryString += " e." + propertyName.get(i) + "=" + value.get(i);
				} else {
					queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
				}
			}
			queryString += "" + ")";
		}
		// 若order不为空，添加排序条件
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

	// TODO:获取单一字段的查询.仅支持字符串
	public List<String> findSingleField(List<String> propertyName, List<String> value, String name, Integer andEnd,
			Integer equalEnd) {
		String queryString = "select "+name+" from " + entityClass.getSimpleName() + " e where ";
		int i = 0;
		// 添加查询条件
		for (; i < andEnd; i++) {// 先添加and条件
			if (i > 0)
				queryString += " and ";// 若and条件个数大于1个，添加and关键词
			if (i < equalEnd) {// 根据equalEnd决定此属性是精准查询还是模糊查询
				queryString += " e." + propertyName.get(i) + "=" + value.get(i);
			} else {
				queryString += " e." + propertyName.get(i) + " like '%" + value.get(i) + "%'";
			}
		}
		if (i < propertyName.size()) {
			if (i > 0) {
				queryString += " and ";// 如果前面有and条件，先添加and关键词
			}
			queryString += "(";
			for (; i < propertyName.size(); i++) {// 添加or条件
				if (i > andEnd) {
					queryString += " or ";// 如果or条件个数大于1个，添加or关键词
				}
				if (i < equalEnd) {// 根据equalEnd决定此属性是精准查询还是模糊查询
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
	public int findAllCanByDate(String value1, String date1, String date2) {
		String namString = entityClass.getSimpleName();
		String queryString = "SELECT sum(Amount) from " + entityClass.getSimpleName() + " e ";
		queryString += "where Type = '"+value1+ "' and Date between '"+date1+"' and '"+date2+"'";
		Query query = this.getSession().createQuery(queryString);
		List<Long> list = query.list();
		int a=0;
		if(list.get(0)!=null)
			 a=list.get(0).intValue();
		return a;
	}
}
