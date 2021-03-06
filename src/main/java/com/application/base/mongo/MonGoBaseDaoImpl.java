package com.application.base.mongo;

import java.util.List;
import java.util.Map;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.application.base.mongo.api.MonGoDAO;
import com.application.base.mongo.page.PageView;
import com.mongodb.WriteResult;

/**
 * <b>function:</b> 集合持久层的公用的增，删，改，查接口
 */
public class MonGoBaseDaoImpl<T, K> extends MonGoDAO<T, K> implements MonGoBaseDao<T, K> {

	@Override
	public T findObjById(K pk) {
		return super.get(pk);
	}

	@Override
	public T findObjByName(String proKey, String proValue) {
		return super.findOne(proKey, proValue);
	}

	@Override
	public T findObjByProps(Map<String, ?> params) {
		Query<T> query = super.getQuery(params);
		return super.findOne(query);
	}

	@Override
	public List<T> findList(PageView pageView, Map<String, ?> params) {
		int offset = pageView.getStartPage() * pageView.getPageSize();
		int limit = pageView.getPageSize();
		return super.query(params, offset, limit);
	}

	@Override
	public PageView findPage(PageView pageView, Map<String, ?> params) {
		return super.findPage(pageView, params);
	}

	@Override
	public List<T> findAll() {
		Query<T> query = createQuery();
		return super.find(query).asList();
	}

	@Override
	public List<T> findAllByPros(Map<String, ?> params) {
		Query<T> query = getQuery(params);
		return super.find(query).asList();
	}

	@Override
	public int addOne(T t) {
		Key<T> one = super.save(t);
		if (one != null) {
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public boolean addAll(List<T> ts) {
		boolean result = true;
		for (T t : ts) {
			Key<T> one = super.save(t);
			if (one == null) {
				result = false;
				return result;
			}
		}
		return result;
	}

	@Override
	public int updateOne(K pk, Map<String, ?> params) {
		return super.update(pk, params);
	}
	
	@Override
	public UpdateResults updateOneByResult(Query<T> query, UpdateOperations<T> ops) {
		return super.update(query, ops);
	}

	@Override
	public boolean updateAll(List<K> pks,List<Map<String, ?>> ts) {
		boolean result = true;
		for (int i = 0,j=0; i<pks.size(); i++,j++) {
			int count = super.update(pks.get(i), ts.get(j));
			if (count<1) {
				result = false;
				return result;
			}
		}
		return result;
	}

	@Override
	public int deleteByObjId(K pk) {
		WriteResult result = super.deleteById(pk);
		return result.getN();
	}

	@Override
	public boolean deleteAll(List<K> pks) {
		boolean result = true;
		for (K pk : pks) {
			int count = super.deleteById(pk).getN();
			if (count < 1) {
				result = false;
				return result;
			}
		}
		return result;
	}

	@Override
	public long getObjsCount() {
		return super.count();
	}

	@Override
	public long getObjsByProsCount(Map<String, ?> params) {
		return super.count(params);
	}

	public static final int key_auto_number = 10000;
	
	@Override
	public long getNextIdValue() {
		long now = System.currentTimeMillis();
		long r = Double.valueOf(Math.random() * key_auto_number).longValue();
		long k = now * key_auto_number + r;
		return k;
	}

}
