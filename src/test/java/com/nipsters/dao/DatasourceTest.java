package com.nipsters.dao;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import com.nipsters.dao.Datasource;
import com.nipsters.exceptions.FailureConnectionException;
public class DatasourceTest {
    @Test
    public void testGetConnection(){
        try{
            System.out.println("Iniciando teste de conexão...");
            Datasource.getConnection();
            System.out.println("Teste concluído com sucesso");
        }catch(FailureConnectionException fce){
            System.out.println("Conexão falhou!");
        }
    }
}

