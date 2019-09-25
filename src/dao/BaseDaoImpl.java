package dao;
/**
* @author 
* @version ����ʱ�䣺2019��9��23�� ����1:57:18
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

	@Override
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

	@Override
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

	@Override
	public void delete(int id) {
		TEntity entity = get(id);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TEntity> findAll(String cond) {
		if (cond != null) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		List<TEntity> entities = this.getSession().createQuery("from " + entityClass.getSimpleName() + cond).list();
		return entities;
	}

	@Override
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

	@Override
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
	@Override
	public TEntity get(int id) {
		Session session = this.getSession();
		session.beginTransaction();
		TEntity entity = (TEntity) session.get(entityClass, id);
		session.getTransaction().commit();
		session.close();
		return entity;
	}

	@Override
	public TEntity getSingle(String propertyName, Object propertyValue) {
		System.out.println("lllllllllllllllllllllllllllllllllllllllllllllllll");
		System.out.println(propertyValue);
		List<TEntity> entities = findBy(propertyName, propertyValue);
		if (entities != null && entities.size() > 0) {
			return entities.get(0);
		}
		return null;
	}
	//��չ�Ķ����ݿ�˫���Բ�ѯ
	public	List<TEntity> findByTwoProperty(String propertyName1,String propertyName2, String cond1, String cond2){
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName1 + " like '%" + cond1 + "%'" +" or e." +propertyName2+" like '%" + cond1 + "%'";
		List<TEntity> entities = this.getSession().createQuery(queryString).list();
		return entities;
	}
}
