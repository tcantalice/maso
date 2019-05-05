package com.nipsters.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    
    private String url;
    private String username;
    private String password;

    public Datasource(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Datasource(String url){
        this(url, "root", "");
    }

    public Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(this.url, this.username, this.password);
        }
        catch(SQLException sqle){
            // TODO Exceções para problemas em conectar com o banco
            try{
                conn = DriverManager.getConnection(this.url, "root", "");
            }
            catch(SQLException sqlex){

            }
        }
        return conn;
    }
	
}