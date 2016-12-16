package com.application.base.mongo;

import java.util.List;
import java.util.Map;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.application.base.mongo.page.PageView;

/**
 * <b>function:</b> 集合持久层的公用的增，删，改，查接口
 */
public interface MonGoBaseDao<T,K> {
	
	/**
	 * 通过主键查询
	 * @param pk
	 * @return
	 */
	public T findObjById(K pk);
	
	/**
	 * 通过名字查询
	 * @param proKey,proValue
	 * @return
	 */
	public T findObjByName(String proKey,String proValue);
	
	/**
	 * 通过对象查找对象
	 * @param params
	 * @return
	 */
	public T findObjByProps(Map<String, ?> params);
	
	/**
	 * 返回分页后的数据
	 * @param pageView
	 * @param params
	 * @return
	 */
	public List<T> findList(PageView pageView,Map<String, ?> params);
	
	/**
	 * 返回分页后的数据
	 * @param pageView
	 * @param params
	 * @return
	 */
	public PageView findPage(PageView pageView,Map<String, ?> params);
	
	/**
	 * 返回所有数据
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 返回所有数据
	 * @param params
	 * @return
	 */
	public List<T> findAllByPros(Map<String, ?> params);
	
	/**
	 * 添加
	 * @param t
	 */
	public int addOne(T t);
	
	/**
	 * 添加所有
	 * @param ts
	 */
	public boolean addAll(List<T> ts);
	
	/**
	 * 修改
	 * @param t
	 */
	public int updateOne(K pk,Map<String, ?> params);  
	
	/**
	 * 修改
	 * @param t
	 */
	public UpdateResults updateOneByResult(Query<T> query, UpdateOperations<T> ops);
	
	/**
	 * 修改所有属性.
	 * @param ts
	 */
	public boolean updateAll(List<K> pks,List<Map<String, ?>> ts);
	
	/**
	 * 删除
	 * @param pk
	 */
	public int deleteByObjId(K pk);

	/**
	 * 删除所有
	 * @param pks
	 */
	public boolean deleteAll(List<K> pks);	

	/**
	 * 获得总条数.
	 * @return
	 */
	public long getObjsCount();	
	
	/**
	 * 通过条件获得总条数.
	 * @return
	 */
	public long getObjsByProsCount(Map<String, ?> params);	
	
}
