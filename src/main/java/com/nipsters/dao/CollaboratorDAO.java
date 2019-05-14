package com.nipsters.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nipsters.exceptions.UnknownEntityException;
import com.nipsters.exceptions.FailureConnectionException;
import com.nipsters.model.Collaborator;
import com.nipsters.model.Genres;

public class CollaboratorDAO implements DAO<Collaborator>{

    private static Map<Integer, Collaborator> cache = new HashMap<>();
    private static CollaboratorDAO instance;

    private CollaboratorDAO(){}

    public static CollaboratorDAO getInstance(){
        if(instance == null)
            instance = new CollaboratorDAO();
        return instance;
    }

    public Collaborator getById(int id) throws SQLException, UnknownEntityException{
        if(cache.containsKey(id))
            return cache.get(id);
        
        Statement statement = null;
        try{
            statement = Datasource.getConnection().createStatement();
        }
        catch(FailureConnectionException fce){
            throw new SQLException(fce);
        }

        ResultSet result = statement.executeQuery(
            "SELECT * FROM collaborators WHERE id = " + id + ";");
        if(result.next()){
            return new Collaborator(id,
            result.getString("name"),
            result.getDate("birth").toLocalDate(),
            Genres.valueOf(result.getInt("genre")),
            result.getString("function"),
            result.getString("sector"));
        }
        throw new UnknownEntityException();
    }

    @Override
    public void insert(Collaborator entity) throws SQLException{
        PreparedStatement statement = null;
        try{
            statement = Datasource.getConnection().prepareStatement(
                "INSERT INTO collaborators (name, genre, birth, function, sector) VALUES (?,?,?,?,?)"
            );
        }catch(FailureConnectionException fce){
            throw new SQLException(fce);
        }
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getGenre().getValue());
        statement.setDate(3, Date.valueOf(entity.getBirth()));
        statement.setString(4, entity.getFunction());
        statement.setString(5, entity.getSector());
        statement.executeUpdate();
    }

    @Override
    public void insert(List<Collaborator> entities) throws SQLException{
        for(Collaborator entity : entities){
            this.insert(entity);
        }
    }

    @Override
    public List<Collaborator> select() throws SQLException {
        String sql = "SELECT * FROM collaborators";
        List<Collaborator> entities = new ArrayList<>();
        Statement statement = null;

        try{
            statement = Datasource.getConnection().createStatement();
        }catch(FailureConnectionException fce){
            throw new SQLException(fce);
        }
        ResultSet results = statement.executeQuery(sql);
        while(results.next()){
            entities.add(new Collaborator(
                results.getInt("id"),
                results.getString("name"),
                results.getDate("birth").toLocalDate(),
                Genres.valueOf(results.getInt("genre")),
                results.getString("function"),
                results.getString("sector")
            ));
        }

        return null;
    }

    @Override
    public void update(List<Collaborator> entities) throws SQLException{}

    @Override
    public void delete(Collaborator entity) throws SQLException{}

    @Override
    public void delete(List<Collaborator> entities) throws SQLException{}
    
}