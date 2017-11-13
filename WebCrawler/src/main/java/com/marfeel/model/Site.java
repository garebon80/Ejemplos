package com.marfeel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="site")
public class Site{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="url")
	String url;	
	
	@Column(name="rank")
	long rank;
	
	public Site() {
		super();
	}
	public Site(int id, String url, long rank) {
		super();
		this.id = id;
		this.url = url;
		this.rank = rank;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public long getRank() {
		return rank;
	}
	
	public void setRank(long rank) {
		this.rank = rank;
	}	
}