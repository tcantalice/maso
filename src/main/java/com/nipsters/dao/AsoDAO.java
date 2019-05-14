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

import com.nipsters.exceptions.FailureConnectionException;
import com.nipsters.exceptions.UnknownEntityException;
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
        PreparedStatement statement = null;
        try{
            statement = Datasource.getConnection().prepareStatement(
            "INSERT INTO aso (number, id_collaborator, dated_to, type) VALUES (?,?,?,?)");
        }catch(FailureConnectionException fce){
            throw new SQLException(fce);
        }
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
        Statement statement = null;
        try{
            statement = Datasource.getConnection().createStatement();
        }catch(FailureConnectionException fce){
            throw new SQLException(fce);
        }
        ResultSet results = statement.executeQuery(sql);
        while(results.next()){
            try{
                entities.add(new Aso(
                    results.getInt("number"),
                    CollaboratorDAO.getInstance().getById(results.getInt("id_collaborators")),
                    TypeASO.valueOf(results.getInt("type")),
                    results.getDate("dated_to").toLocalDate()
                ));
            }
            catch(UnknownEntityException uee){
                continue;
            }
        }
        return entities;
    }

    @Override
    public void update(List<Aso> entitie){

    }

    @Override
    public void delete(Aso entity){
        
    }

    @Override
    public void delete(List<Aso> entities){}
    
}