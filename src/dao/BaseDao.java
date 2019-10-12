package dao;

import java.util.List;

/**
 * @author
 * @version 创建时间：2019年9月23日 下午2:04:16
 * 
 */
public interface BaseDao<TEntity> {
	/**
	 * @param id The primary Id of the entity
	 * @return the entity identified by the Id
	 */
	TEntity get(int id);

	/**
	 * get single entity by specified property
	 * 
	 * @param propertyName  The name of the property
	 * @param propertyValue The value of the property
	 * @return the entity specialized by the property
	 */
	TEntity getSingle(String propertyName, Object propertyValue);

	/**
	 * save the entity
	 * 
	 * @param entity The entity to be saved.
	 */
	void save(TEntity entity);

	void merge(TEntity entity);

	/**
	 * delete an entity with the primary key id
	 * 
	 * @param id The primary key id of the entity to be deleted.
	 */
	void delete(int id);

	/**
	 * delete the entity
	 * 
	 * @param entity the entity to be deleted.
	 */
	void delete(TEntity entity);

	/**
	 * find all the entity from DAO
	 * 
	 * @return the List of entities found
	 */
	List<TEntity> findAll();

	List<TEntity> findAll(String cond);

	/**
	 * find entities with the specified property
	 * 
	 * @param propertyName  The name of the property
	 * @param propertyValue The value of the property
	 * @return the List of entities specialized by the property
	 */
	List<TEntity> findBy(String propertyName, Object propertyValue);

	List<TEntity> findBy(String propertyName, Object propertyValue, String cond);

	List<TEntity> findBySubString(String propertyName, String cond);

	// 拓展的对数据库双属性查询
	List<TEntity> findByTwoProperty(String propertyName1, String propertyName2, String cond1);
	//拓展的双属性精准查询
	List<TEntity> getByTwoProperty(String propertyName1, String propertyName2, Object Value1,Object Value2);
	// 拓展ID数组查询
	List<TEntity> findByIDList(List<Integer> IDlist);

	// 拓展分页查询
	int findTotalNum(String propertyName, Object propertyValue);

	List<TEntity> findPageByQuery(String propertyName, Object propertyValue, String cond, int pageStart, int pageSize);

	List<TEntity> findPageByTwoProperty(String propertyName1, String propertyName2, String cond1, int pageStart,
			int pageSize);

	int findTotalNumbyTwoSubstring(String propertyName1, String propertyName2, String cond1);
}
