package com.javabase.demo.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.base.mongo.page.PageView;


@Service("iMongoService")
public class MongoServiceImpl implements IMongoService {

    @Autowired
    private IMongoDao iMongoDao;

    public List<Mongo> query() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("order", "tags"); //排序
        return iMongoDao.query(params, 10, 10);
    }

	@Override
	public Mongo findObjById(ObjectId pk) {
		return iMongoDao.findObjById(pk);
	}

	@Override
	public Mongo findObjByName(String proKey, String proValue) {
		return iMongoDao.findObjByName(proKey, proValue);
	}

	@Override
	public Mongo findObjByProps(Map<String, ?> params) {
		return iMongoDao.findObjByProps(params);
	}

	@Override
	public List<Mongo> findList(PageView pageView, Map<String, ?> params) {
		return iMongoDao.findList(pageView, params);
	}

	@Override
	public PageView findPage(PageView pageView, Map<String, ?> params) {
		return iMongoDao.findPage(pageView, params);
	}

	@Override
	public List<Mongo> findAll() {
		return iMongoDao.findAll();
	}

	@Override
	public List<Mongo> findAllByPros(Map<String, ?> params) {
		return findAllByPros(params);
	}

	@Override
	public int addOne(Mongo t) {
		return iMongoDao.addOne(t);
	}

	@Override
	public boolean addAll(List<Mongo> ts) {
		return iMongoDao.addAll(ts);
	}

	@Override
	public int updateOne(ObjectId pk, Map<String, ?> params) {
		return iMongoDao.updateOne(pk, params);
	}

	@Override
	public UpdateResults updateOneByResult(Query<Mongo> query, UpdateOperations<Mongo> ops) {
		return iMongoDao.updateOneByResult(query, ops);
	}

	@Override
	public boolean updateAll(List<ObjectId> pks, List<Map<String, ?>> ts) {
		return iMongoDao.updateAll(pks, ts);
	}

	@Override
	public int deleteByObjId(ObjectId pk) {
		return iMongoDao.deleteByObjId(pk);
	}

	@Override
	public boolean deleteAll(List<ObjectId> pks) {
		return iMongoDao.deleteAll(pks);
	}

	@Override
	public long getObjsCount() {
		return iMongoDao.getObjsCount();
	}

	@Override
	public long getObjsByProsCount(Map<String, ?> params) {
		return iMongoDao.getObjsByProsCount(params);
	}

}
