package com.javabase.demo.web.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.base.common.BaseController;
import com.application.base.mongo.page.PageView;
import com.javabase.demo.mongo.IMongoService;
import com.javabase.demo.mongo.Mongo;


/**
 * 
 * Controller
 *
 * @author bruce
 * 
 */
 
@Controller
@RequestMapping("/background/mongo/")
public class  MongoController  extends BaseController {

	private final static Logger logger= Logger.getLogger(MongoController.class);
	
	// Servrice start
	@Autowired(required=false)
	private IMongoService iMongoService  ; 
    

	@RequestMapping("find")
	public String find(Model model, Mongo imongo, String pageNow,String pageSize ) {
	    PageView pageView = super.findPage(pageNow, pageSize);  
        Map<String, String> params = new  HashMap<String,String>();
        //params 为要通过条件来查询的key-value 键值对,示例如下:
        //params.put("id_@like", city.getId());
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
        model.addAttribute("pageView", pageView);
		return "/background/mongo/list";
	}
	
	@RequestMapping("findById")
    public String findById(Model model, String objId, int type) {
        ObjectId objectId = new ObjectId(objId);
        Mongo mongo =iMongoService.findObjById(objectId);
        model.addAttribute("object", mongo);
        model.addAttribute("objId", objId);
        if (type == 1) {
            return "/background/mongo/edit";
        } else {
            return "/background/mongo/show";
        }
    }
	
	@RequestMapping("findByName")
	public void findByName(Model model, String objName) {
		String data = null;
		try {
			Mongo mongo = iMongoService.findObjByName("objPros",objName); //objPros:为要查询的字段,示例:
			//City city = cityService.findByMongoName("text", objName);		
			if (mongo != null) {
				data = "({msg:'Y',content:'按需求填写!'})";
			}else {
				data = "({msg:'N',content:'按需求填写!'})";
			}
			//返回.
			ajaxJson(response,data);
		} catch (Exception e) {
			logger.info("查找出错!"+e.getLocalizedMessage());
		}
	}
	
	@RequestMapping("findByProps")
	public void findByProps(Model model, Mongo mongo) {
		String data = null;
		try {
    		Map<String, Object> params = new  HashMap<String,Object>();
            /* 以下为示例. 使用时候根据实际去填写.
            if (city.getId()!=null) {
                params.put("id", city.getId());
            }
            */
            Mongo object = iMongoService.findObjByProps(params);
			if (object != null) {
				data = "({msg:'Y',content:'按需求填写!'})";
			}else {
				data = "({msg:'N',content:'按需求填写!'})";
			}
			//返回.
			ajaxJson(response,data);
		} catch (Exception e) {
			logger.info("查找出错!"+e.getLocalizedMessage());
		}
	}
	
    @RequestMapping("addUI")
    public String addUI() {
        return "/background/mongo/add";
    }
	
	@RequestMapping("addOne")
	public String addOne(Model model, Mongo mongo) {
		iMongoService.addOne(mongo);
		return "redirect:find.html";
	}
	
	@RequestMapping("deleteById")
	public void deleteById(Model model, String objId) {
		String data = null;
        try {
            ObjectId objectId = new ObjectId(objId);
            int count = iMongoService.deleteByObjId(objectId);
            if (count >0 ) {
                data = "({msg:'Y',content:'删除成功!'})";
            }else {
                data = "({msg:'N',content:'删除失败!'})";
            }
            //返回.
            ajaxJson(response,data);
        } catch (Exception e) {
            logger.info("查找出错!"+e.getLocalizedMessage());
        }
	}
	
	@RequestMapping("updateById")
	public String updateById(Model model, Mongo mongo,String _id) {
		ObjectId objectId = new ObjectId(_id);        
        mongo.set_id(objectId);
        Map<String, Object> params = new HashMap<>();
        params.put("_id", objectId.toString());
        iMongoService.updateOne(objectId, params);
		return "redirect:find.html";
	}
}
