package com.orangeslate.naturestore.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orangeslate.naturestore.domain.Tree;
import com.orangeslate.naturestore.repository.NatureRepositoryImpl;
import com.orangeslate.naturestore.repository.Repository;

public class MongoTest {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext.xml");

		// Repository repository =
		// (Repository)context.getBean("natureRepository");

		Repository repository = context.getBean(NatureRepositoryImpl.class);

		// cleanup collection before insertion
		repository.dropCollection();

		// create collection
		repository.createCollection();

		repository.saveTree(new Tree("1", "Apple Tree", 10));

		System.out.println("1. " + repository.getAllTrees());

		repository.saveTree(new Tree("2", "Orange Tree", 3));

		System.out.println("2. " + repository.getAllTrees());

		System.out.println("Tree with id 1" + repository.getTree("1"));

		repository.updateTree("1", "Peach Tree");

		System.out.println("3. " + repository.getAllTrees());

		repository.deleteTree("2");

		System.out.println("4. " + repository.getAllTrees());
	}
}
