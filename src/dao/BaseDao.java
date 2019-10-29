package dao;

import java.util.List;

/**
 * @author
 * @version ����ʱ�䣺2019��9��23�� ����2:04:16
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

	// ��չ�Ķ����ݿ�˫���Բ�ѯ
	List<TEntity> findByTwoProperty(String propertyName1, String propertyName2, String cond1);

	// ��չ��˫���Ծ�׼��ѯ
	List<TEntity> getByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2);

	// ��չID�����ѯ
	List<TEntity> findByIDList(List<Integer> IDlist);

	// ��չ��ҳ��ѯ
	int findTotalNum(String propertyName, Object propertyValue);

	List<TEntity> findPageByQuery(String propertyName, Object propertyValue, String cond, int pageStart, int pageSize);

	List<TEntity> findPageByTwoProperty(String propertyName1, String propertyName2, String cond1, int pageStart,
			int pageSize);

	int findTotalNumbyTwoSubstring(String propertyName1, String propertyName2, String cond1);

	int findTotalNumbyTwoProperty(String propertyName1, String propertyName2, Object value1, Object value2);

	List<TEntity> getPageByTwoProperty(String propertyName1, String propertyName2, Object Value1, Object Value2,
			String cond, int pageStart, int pageSize);
int numOfReader();
	// TODO:���ܵķ�ҳ��ѯ���������з�ҳ��ѯ��ʽ
	/**
	 * 
	 * @param propertyName Ҫ��ѯ���������б�
	 * @param value        Ҫ��ѯ������ֵ�б�
	 * @param andEnd       �ڵڼ�����������and��䣬��Ϊ0��û��and���
	 * @param equalEnd     �ڵڼ�����������"="�жϣ���Ϊ0��û�С�=�����
	 * @return Total number of records �������з��������ļ�¼��
	 */
	public Integer findTotalNum(List<String> propertyName, List<String> value, Integer andEnd, Integer equalEnd);

	/**
	 * 
	 * @param propertyName Ҫ��ѯ���������б�
	 * @param value        Ҫ��ѯ������ֵ�б�
	 * @param andEnd       �ڵڼ�����������and��䣬��Ϊ0��û��and���
	 * @param equalEnd     �ڵڼ�����������"="�жϣ���Ϊ0��û�С�=�����
	 * @param desWhen      �ӵڼ�������������ʼ������
	 * @param pageStart    ��ҳ��ʼ����
	 * @param pageSize     ��ҳ�Ĵ�С
	 * @return ��ҳ��ѯ���б�
	 */
	// TODO:���ܵķ�ҳ��ѯ���������з�ҳ��ѯ��ʽ
	public List<TEntity> findPage(List<String> propertyName, List<String> value, List<String> order, Integer andEnd,
			Integer equalEnd, Integer desWhen, int pageStart, int pageSize);
	//TODO:��ȡ��һ�ֶεĲ�ѯ
	int findAllCanByDate(String value1, String value2, String value3);
	public List<String> findSingleField(List<String> propertyName, List<String> value,String name, Integer andEnd, Integer equalEnd);
}
