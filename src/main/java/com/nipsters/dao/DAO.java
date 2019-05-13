package com.nipsters.dao;

import java.util.List;
import java.sql.SQLException;

public interface DAO<E> {
    public void insert(E entity) throws SQLException;
    public void insert(List<E> entities) throws SQLException;
    public List<E> select() throws SQLException;
    public void update(List<E> entities) throws SQLException;
    public void delete(E entity) throws SQLException;
    public void delete(List<E> entities) throws SQLException;
}