package com.javabase.demo.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class PageInfosTest {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{
				"classpath:spring/applicationContext.xml"
		});
		IMongoService service = (IMongoService) ctx.getBean("iMongoService");
		List<Mongo> cities = service.findAll();
		int index = 0;
		for (Mongo city : cities) {
			System.out.println("title="+city.getTitle()+",description="+city.getDescription()+",url="+city.getUrl());
			index++;
		}
		System.out.println(index);

		NOSQLDAO<Mongo, ObjectId> dao =  new NOSQLDAO<Mongo, ObjectId>();
		Map<String, Object> params = new HashMap<String, Object>();
		List<Mongo> citiess = dao.query(params, 10, 20);
		int indexs = 0;
		for (Mongo city : citiess) {
			System.out.println(city.getTitle());
			indexs++;
		}
		System.out.println(indexs);

	}	
}
