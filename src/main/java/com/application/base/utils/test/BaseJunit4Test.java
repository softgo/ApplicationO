package com.application.base.utils.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit4 测试
 * @author bruce
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext.xml" })
public class BaseJunit4Test {

	/**
	 * 其他的数据源测试，都要经过继承这个类来实现 service 的操作数据库行为。
	 */
	
}
