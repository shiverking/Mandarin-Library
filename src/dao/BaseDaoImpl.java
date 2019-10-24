package dao;
/**
* @author 
* @version 锟斤拷锟斤拷时锟戒：2019锟斤拷9锟斤拷23锟斤拷 锟斤拷锟斤拷1:57:18
* 
*/

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

	// 锟斤拷展锟侥讹拷锟斤拷锟捷匡拷双锟斤拷锟皆诧拷询
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
		if (cond != null) {
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

	public List<TEntity> findPageByTwoSubstring(String propertyName1, String propertyName2, String cond1, String cond2,
			int pageStart, int pageSize) {
		// TODO:锟斤拷页锟斤拷锟斤拷
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
	public List<TEntity> findPageByTwoProperty(String propertyName1,String propertyName2, Object Value1, Object Value2, String cond, int pageStart, int pageSize){
		if (cond != null) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + "=:Value1" +" and e." + propertyName2 + "=:Value2"+ cond;
		Query query = this.getSession().createQuery(queryString);
		query.setParameter("Value1", Value1);
		query.setParameter("Value2", Value2);
		query.setFirstResult(pageStart);
		query.setMaxResults(pageSize);
		List<TEntity> results = query.list();
		return results;
	}
	//璇诲彇璇昏�呮暟鐩�
		public int numOfReader() {
			String queryString = "select count(*) from " + entityClass.getSimpleName() + " e ";
			Query query = this.getSession().createQuery(queryString);
			List<Long> list = query.list();
			return list.isEmpty() ? 0 : list.get(0).intValue();
		}
}
