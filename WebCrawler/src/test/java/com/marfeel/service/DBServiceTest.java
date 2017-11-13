//package com.marfeel.service;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.util.Assert;
//import com.marfeel.dao.SiteDAO;
//import com.marfeel.model.Site;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
//public class DBServiceTest {
//	
//	@Autowired
//	SiteDAO siteDao;
//	
//	@Test
//	public void testDBService(){
//		Site site = new Site();
//		site.setRank(34234);
//		site.setUrl("google.com");		
//		siteDao.addSite(site).getUrl();		
//		Assert.hasText("google.com", siteDao.addSite(site).getUrl());	
//	}
//
//}
