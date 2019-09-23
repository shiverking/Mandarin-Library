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
	 * @param propertyName The name of the property
	 * @param propertyValue The value of the property
	 * @return  the entity specialized by the property
	 */
	TEntity getSingle(String propertyName, Object propertyValue);
	
	/**
	 * save the entity
	 * @param entity The entity to be saved.
	 */
	void save(TEntity entity);
	
	void merge(TEntity entity);
	
	/**
	 * delete an entity with the primary key id
	 * @param id The primary key id of the entity to be deleted.
	 */
	void delete(int id);
	
	/**
	 * delete the entity
	 * @param entity the entity to be deleted.
	 */
	void delete(TEntity entity);
	
	/**
	 * find all the entity from DAO
	 * @return  the List of entities found
	 */
	List<TEntity> findAll();
	List<TEntity> findAll(String cond);
	
	/**
	 * find entities with the specified property
	 * @param propertyName The name of the property
	 * @param propertyValue The value of the property
	 * @return the List of entities specialized by the property
	 */
	List<TEntity> findBy(String propertyName, Object propertyValue);
	List<TEntity> findBy(String propertyName, Object propertyValue,String cond);
	List<TEntity> findBySubString(String propertyName, String cond);
	
	
}
