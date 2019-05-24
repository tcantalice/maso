package com.nipsters.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.nipsters.model.Aso;
import com.nipsters.model.TypeASO;

public class AsoDAO implements DAO<Aso>{

    private static Map<Integer, Aso> cache = new HashMap<>();
    private static AsoDAO instance;

    private AsoDAO(){}

    public static AsoDAO getInstance(){
        if(instance == null)
            instance = new AsoDAO();
        return instance;
    }

    @Override
    public void insert(Aso entity) throws SQLException {
        PreparedStatement statement = Datasource.getConnection().prepareStatement(
            "INSERT INTO aso (number, id_collaborator, dated_to, type) VALUES (?,?,?,?)");
        statement.setInt(1, entity.getNumber());
        statement.setInt(2, entity.getCollaborator().getId());
        statement.setDate(3, Date.valueOf(entity.getDated()));
        statement.setInt(4, entity.getType().getValue());
        statement.execute();
    }
    
    @Override
    public void insert(List<Aso> entities) throws SQLException{
        for(Aso entity : entities){
            this.insert(entity);
        }
    }

    @Override
    public List<Aso> select() throws SQLException{
        String sql = "SELECT * FROM asos";
        List<Aso> entities = new ArrayList<>();
        Statement statement = Datasource.getConnection().createStatement();

        ResultSet results = statement.executeQuery(sql);
        /*while(results.next()){
            entities.add(new Aso(
                results.getInt("number"),
                
            ));
        }*/
       
        return entities;
    }

    @Override
    public void update(Aso entity) throws SQLException{
        String sql = "UPDATE asos SET number = ?, collaborator = ?, type = ?, dated = ? WHERE number = ?;";
        PreparedStatement statement = Datasource.getConnection().prepareStatement(sql);
        statement.setInt(1, entity.getNumber());
        statement.setInt(5, entity.getNumber());
        statement.setInt(2, entity.getCollaborator().getId());
        statement.setInt(3, entity.getType().getValue());
        statement.setDate(4, Date.valueOf(entity.getDated()));
        statement.executeUpdate();
    }

    @Override
    public void update(List<Aso> entities)throws SQLException{
        for(Aso entity : entities){
            this.update(entity);
        }
    }

    @Override
    public void delete(Aso entity) throws SQLException{
        String sql = "DELETE FROM asos WHERE number = ?;";
        PreparedStatement statement = Datasource.getConnection().prepareStatement(sql);
        statement.setInt(1, entity.getNumber());
        statement.executeUpdate();
    }

    @Override
    public void delete(List<Aso> entities) throws SQLException{
        for(Aso entity : entities){
            this.delete(entity);
        }
    }
    
}