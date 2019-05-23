package com.nipsters.dao;

import org.junit.Test;

import com.nipsters.dao.Datasource;
import com.nipsters.exceptions.FailureConnectionException;
public class DatasourceTest {
    @Test
    public void testGetConnection(){
        Datasource.getConnection();
    }
}

