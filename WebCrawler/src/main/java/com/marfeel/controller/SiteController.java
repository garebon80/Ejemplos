package com.marfeel.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.marfeel.model.Site;
import com.marfeel.service.DBService;
import com.marfeel.service.MarfeelizableService;

@RestController
public class SiteController {	
	
	@Autowired
	DBService dbService;
	
	@Autowired
	MarfeelizableService marfeelizableService;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public @ResponseBody List<Site> addSites(@RequestBody List<Site> siteList)
			throws InterruptedException, ExecutionException, IOException {
		
		ForkJoinPool customThreadPool = new ForkJoinPool(3); 	
		
		List<Site> marfeelizableSites = customThreadPool.submit(() -> siteList.parallelStream()
				.filter(site -> marfeelizableService.checkSite(site.getUrl())))
				.get().collect(Collectors.toList());
		
		for(Site site: marfeelizableSites)
			dbService.addSite(site);		
		
		return marfeelizableSites;
	}		
}
