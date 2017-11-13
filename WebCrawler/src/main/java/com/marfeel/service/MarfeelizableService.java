package com.marfeel.service;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service("marfeelizableService")
public class MarfeelizableService {	
	
	public boolean checkSite(String url) {
	
		Document doc = null;
		try {
			doc = Jsoup.connect("http://"+url+"/").get();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		System.out.println(doc.title());		
		
		if (( doc.title().toLowerCase().indexOf("news") != -1 ) 
		|| ( doc.title().toLowerCase().indexOf("noticias") != -1 )) 
			return true;		
		else 		
			return false;			
	}	

}
