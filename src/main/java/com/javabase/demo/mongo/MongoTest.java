package com.javabase.demo.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.base.mongo.page.Common;
import com.application.base.mongo.page.PageView;
import com.application.base.utils.test.BaseJunit4Test;

public class MongoTest extends BaseJunit4Test {

	@Autowired
	private IMongoService iMongoService;
	
	@Test
	public void testAll(){
		List<Mongo> mongos = iMongoService.findAll();
		for (Mongo mongo : mongos) {
			System.out.println("title="+mongo.getTitle()+",desc="+mongo.getDescription()+",url="+mongo.getUrl());
			String[] tags = mongo.getTags();
			for (String tag : tags) {
				System.out.println("tag = "+tag);
			} 
		}
	}
	
	@Test
	public void testPage(){
		PageView pageView = findPage("1","1");
		Map<String, ?> params = new HashMap<>();
		pageView = iMongoService.findPage(pageView, params);
		System.out.println("pageNo="+pageView.getPageNow()+",pageSize="+pageView.getPageSize()+",pageCount="+pageView.getPageCount()+",pagecode = "+pageView.getPagecode());
		List<Mongo> mongos = pageView.getRecords();
		for (Mongo mongo : mongos) {
			System.out.println("title="+mongo.getTitle()+",desc="+mongo.getDescription()+",url="+mongo.getUrl());
			String[] tags = mongo.getTags();
			for (String tag : tags) {
				System.out.println("tag = "+tag);
			} 
		}
	}
	
	
	public PageView findPage(String pageNow,String pageSize ){
		PageView pageView = null;
		//默认显示.
		if(Common.isEmpty(pageNow) && Common.isEmpty(pageSize)){
			pageView = new PageView(1);
		//输入有页数,默认展示条数.
		}else if(!Common.isEmpty(pageNow) && Common.isEmpty(pageSize) ){
			pageView = new PageView(Integer.parseInt(pageNow));
		//设置页数和每页显示的条数.
		}else if(Common.isEmpty(pageNow) && !Common.isEmpty(pageSize)) {
			pageView = new PageView(1,Integer.parseInt(pageSize));
		//设置页数和每页显示的条数.
		}else {
			pageView = new PageView(Integer.parseInt(pageNow),Integer.parseInt(pageSize));
		}
		return pageView;
	}
	
}
