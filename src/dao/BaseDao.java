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

	// 拓展的双属性精准查询
	List<TEntity> getByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2);

	// 拓展ID数组查询
	List<TEntity> findByIDList(List<Integer> IDlist);

	// 拓展分页查询
	int findTotalNum(String propertyName, Object propertyValue);

	List<TEntity> findPageByQuery(String propertyName, Object propertyValue, String cond, int pageStart, int pageSize);

	List<TEntity> findPageByTwoProperty(String propertyName1, String propertyName2, String cond1, int pageStart,
			int pageSize);

	int findTotalNumbyTwoSubstring(String propertyName1, String propertyName2, String cond1);

	int findTotalNumbyTwoProperty(String propertyName1, String propertyName2, Object value1, Object value2);

	List<TEntity> getPageByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2,
			String cond, int pageStart, int pageSize);

	// TODO:万能的分页查询，涵盖所有分页查询方式
	/**
	 * 
	 * @param propertyName 要查询的条件名列表
	 * @param value        要查询的条件值列表
	 * @param andEnd       在第几个条件结束and语句，若为0则没有and语句
	 * @param equalEnd     在第几个条件结束"="判断，若为0则没有‘=’语句
	 * @return Total number of records 返回所有符合条件的记录数
	 */
	public Integer findTotalNum(List<String> propertyName, List<String> value, Integer andEnd, Integer equalEnd);

	/**
	 * 
	 * @param propertyName 要查询的条件名列表
	 * @param value        要查询的条件值列表
	 * @param andEnd       在第几个条件结束and语句，若为0则没有and语句
	 * @param equalEnd     在第几个条件结束"="判断，若为0则没有‘=’语句
	 * @param desWhen      从第几个排序条件开始逆序，若
	 * @param pageStart    分页起始索引
	 * @param pageSize     分页的大小
	 * @return 分页查询的列表
	 */
	// TODO:万能的分页查询，涵盖所有分页查询方式
	public List<TEntity> findPage(List<String> propertyName, List<String> value, List<String> order, Integer andEnd,
			Integer equalEnd, Integer desWhen, int pageStart, int pageSize);
}
