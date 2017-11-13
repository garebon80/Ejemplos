package com.marfeel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.marfeel.model.Site;

@Repository
public class SiteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public Site addSite(Site site) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(site);
		return site;
	}	
}
