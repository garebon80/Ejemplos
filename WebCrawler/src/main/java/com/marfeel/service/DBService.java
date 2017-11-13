package com.marfeel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.marfeel.dao.SiteDAO;
import com.marfeel.model.Site;

@Service("countryService")
public class DBService {

	@Autowired
	SiteDAO siteDao;

	@Transactional
	public void addSite(Site site) {
		siteDao.addSite(site);
	}
}
