package com.nipsters.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.nipsters.dao.Datasource;

public class DatasourceTest {
    
    @Test
    public void dbDefaultCreds(){
        Datasource ds = new Datasource("jdbc:hsqldb:file:./data");
        assertNotNull("Não houve conexão com o banco", ds.getConnection());
    }

    @Test
    public void dbDefinedCreds(){
        Datasource ds = new Datasource("jdbc:hsqldb:file:./data");
        assertNotNull("Não houve conexão com o banco", ds.getConnection());
    }
}

