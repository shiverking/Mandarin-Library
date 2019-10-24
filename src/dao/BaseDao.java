package dao;

import java.util.List;

/**
 * @author
 * @version ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ä£º2019ï¿½ï¿½9ï¿½ï¿½23ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½2:04:16
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
	void deleteByLS(int id);
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

	// ï¿½ï¿½Õ¹ï¿½Ä¶ï¿½ï¿½ï¿½ï¿½İ¿ï¿½Ë«ï¿½ï¿½ï¿½Ô²ï¿½Ñ¯
	List<TEntity> findByTwoProperty(String propertyName1, String propertyName2, String cond1);
<<<<<<< HEAD
	//ï¿½ï¿½Õ¹ï¿½ï¿½Ë«ï¿½ï¿½ï¿½Ô¾ï¿½×¼ï¿½ï¿½Ñ¯
	List<TEntity> getByTwoProperty(String propertyName1, String propertyName2, Object Value1,Object Value2);
	// ï¿½ï¿½Õ¹IDï¿½ï¿½ï¿½ï¿½ï¿½Ñ¯
=======

	// ÍØÕ¹µÄË«ÊôĞÔ¾«×¼²éÑ¯
	List<TEntity> getByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2);

	// ÍØÕ¹IDÊı×é²éÑ¯
>>>>>>> wjy
	List<TEntity> findByIDList(List<Integer> IDlist);

	// ï¿½ï¿½Õ¹ï¿½ï¿½Ò³ï¿½ï¿½Ñ¯
	int findTotalNum(String propertyName, Object propertyValue);

	List<TEntity> findPageByQuery(String propertyName, Object propertyValue, String cond, int pageStart, int pageSize);

	List<TEntity> findPageByTwoSubstring(String propertyName1, String propertyName2, String cond1,String cond2, int pageStart,
			int pageSize);

	int findTotalNumbyTwoSubstring(String propertyName1, String propertyName2, String cond1);
<<<<<<< HEAD
	int findTotalNumbyTwoProperty(String propertyName1, String propertyName2,Object value1,Object value2);
	int numOfReader();
	List<TEntity> findPageByTwoProperty(String propertyName1,String propertyName2, Object Value1, Object Value2, String cond, int pageStart, int pageSize);
=======

	int findTotalNumbyTwoProperty(String propertyName1, String propertyName2, Object value1, Object value2);

	List<TEntity> getPageByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2,
			String cond, int pageStart, int pageSize);
int numOfReader();
	// TODO:ÍòÄÜµÄ·ÖÒ³²éÑ¯£¬º­¸ÇËùÓĞ·ÖÒ³²éÑ¯·½Ê½
	/**
	 * 
	 * @param propertyName Òª²éÑ¯µÄÌõ¼şÃûÁĞ±í
	 * @param value        Òª²éÑ¯µÄÌõ¼şÖµÁĞ±í
	 * @param andEnd       ÔÚµÚ¼¸¸öÌõ¼ş½áÊøandÓï¾ä£¬ÈôÎª0ÔòÃ»ÓĞandÓï¾ä
	 * @param equalEnd     ÔÚµÚ¼¸¸öÌõ¼ş½áÊø"="ÅĞ¶Ï£¬ÈôÎª0ÔòÃ»ÓĞ¡®=¡¯Óï¾ä
	 * @return Total number of records ·µ»ØËùÓĞ·ûºÏÌõ¼şµÄ¼ÇÂ¼Êı
	 */
	public Integer findTotalNum(List<String> propertyName, List<String> value, Integer andEnd, Integer equalEnd);

	/**
	 * 
	 * @param propertyName Òª²éÑ¯µÄÌõ¼şÃûÁĞ±í
	 * @param value        Òª²éÑ¯µÄÌõ¼şÖµÁĞ±í
	 * @param andEnd       ÔÚµÚ¼¸¸öÌõ¼ş½áÊøandÓï¾ä£¬ÈôÎª0ÔòÃ»ÓĞandÓï¾ä
	 * @param equalEnd     ÔÚµÚ¼¸¸öÌõ¼ş½áÊø"="ÅĞ¶Ï£¬ÈôÎª0ÔòÃ»ÓĞ¡®=¡¯Óï¾ä
	 * @param desWhen      ´ÓµÚ¼¸¸öÅÅĞòÌõ¼ş¿ªÊ¼ÄæĞò£¬Èô
	 * @param pageStart    ·ÖÒ³ÆğÊ¼Ë÷Òı
	 * @param pageSize     ·ÖÒ³µÄ´óĞ¡
	 * @return ·ÖÒ³²éÑ¯µÄÁĞ±í
	 */
	// TODO:ÍòÄÜµÄ·ÖÒ³²éÑ¯£¬º­¸ÇËùÓĞ·ÖÒ³²éÑ¯·½Ê½
	public List<TEntity> findPage(List<String> propertyName, List<String> value, List<String> order, Integer andEnd,
			Integer equalEnd, Integer desWhen, int pageStart, int pageSize);
	//TODO:»ñÈ¡µ¥Ò»×Ö¶ÎµÄ²éÑ¯
	public List<String> findSingleField(List<String> propertyName, List<String> value,String name, Integer andEnd, Integer equalEnd);
>>>>>>> wjy
}
