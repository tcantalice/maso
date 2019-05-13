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

import com.nipsters.exceptions.RegistryNotFoundException;
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

    public Collaborator getById(int id) throws SQLException, RegistryNotFoundException{
        if(cache.containsKey(id))
            return cache.get(id);
        Statement statement = Datasource.getConnection().createStatement();
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
        throw new RegistryNotFoundException();
    }

    @Override
    public void insert(Collaborator entity) throws SQLException{
        PreparedStatement statement = Datasource.getConnection().prepareStatement(
            "INSERT INTO collaborators (name, genre, birth, function, sector) VALUES (?,?,?,?,?)"
        );
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
    public List<Collaborator> select(){
        return null;
    }

    @Override
    public void update(List<Collaborator> entities) throws SQLException{}

    @Override
    public void delete(Collaborator entity) throws SQLException{}

    @Override
    public void delete(List<Collaborator> entities) throws SQLException{}
    
}