package com.javabase.demo.mongo;

import org.bson.types.ObjectId;

import com.application.base.mongo.MonGoBaseDaoImpl;
import com.application.base.mongo.api.DataStore;

/**
 * 这非常的重要,
 * 用这个来设置访问的 Nosql 数据库.
 * 如果没有设置,那么默认的会使用目前配置的:data 数据库.
 * @author rocky
 * @param <T>
 * @param <K>
 */
@DataStore(tagValue = "manager", mongoDBName = "data")
public class NOSQLDAO<T, K>  extends MonGoBaseDaoImpl<Mongo,ObjectId> {
	
	public static final int key_cardinal_number = 1000;

	@Override
	public long getNextIdValue() {
		long now = System.currentTimeMillis();
		long r = Double.valueOf(Math.random() * key_cardinal_number).longValue();
		long k = now * key_cardinal_number + r;
		return k;
	}

}
