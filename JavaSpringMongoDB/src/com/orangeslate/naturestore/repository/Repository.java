package com.orangeslate.naturestore.repository;

import java.util.List;

import com.mongodb.WriteResult;
import com.orangeslate.naturestore.domain.Tree;

public interface Repository {

	public List<Tree> getAllTrees();

	public void saveTree(Tree tree);

	public Tree getTree(String id);

	public WriteResult updateTree(String id, String name);

	public void deleteTree(String id);

	public void createCollection();

	public void dropCollection();
}
