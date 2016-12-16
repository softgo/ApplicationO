package com.javabase.demo.mongo;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.application.base.mongo.MonGoBaseDao;

public interface IMongoDao extends MonGoBaseDao<Mongo,ObjectId> {

    /**
     * 查询城市
     * @param params
     * @param offset
     * @param limit
     * @return
     */
    List<Mongo> query(Map<String, ?> params, int offset, int limit);
    
}
