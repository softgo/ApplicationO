package com.javabase.demo.mongo;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service("iMongoDao")
public class MongoDaoImpl extends NOSQLDAO<Mongo, ObjectId> implements IMongoDao {

    /**
     * @param params
     * @param offset
     * @param limit
     * @return
     */
    public List<Mongo> query(Map<String, ?> params, int offset, int limit){
    	return super.query(params, offset, limit);
    }
    
}
