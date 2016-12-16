package com.javabase.demo.mongo;

import java.util.List;

import org.bson.types.ObjectId;

import com.application.base.mongo.MonGoBaseDao;

public interface IMongoService extends MonGoBaseDao<Mongo,ObjectId> {

    /**
     * 查询城市
     * @return
     */
   public List<Mongo> query();
   
}
