package com.nipsters.dao;

import java.util.List;

public interface DAO<Entity>{
	public void insert(Entity object);
	public List<Entity> getAll();
	public List<Entity> getByFilter(String field, Object value);
	public void remove(String pkValue);
	public void update(Entity object);
}