package com.nipsters.dao;

import java.util.Map;

public interface DAO<Entity,PK>{
	public void insert(Entity object);
	public Map<PK, Entity> getAll();
	public Map<PK, Entity> getByFilter(String field, Object value);
	public void remove(String pkValue);
	public void update(Entity object);
}