package com.nipsters.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nipsters.commons.exceptions.ColaboradorNaoExistenteException;
import com.nipsters.model.Collaborator;
import com.nipsters.model.Genres;

public class CollaboratorDAO implements DAO<Collaborator> {

    private static Map<Integer, Collaborator> cache = new HashMap<>();
    private static CollaboratorDAO instance;
    private static Datasource datasource = Datasource.getInstance();
    private CollaboratorDAO() {}

    /**
     * @return A unique instance of CollaboratorDAO
     */
    public static CollaboratorDAO getInstance() {
        if (instance == null)
            instance = new CollaboratorDAO();
        return instance;
    }

    /**
     * @param entity
     * @throws SQLException
     */
    @Override
    public void insert(Collaborator entity){
        String sql = "INSERT INTO collaborators (name, genre, birth, function, sector) VALUES (?,?,?,?,?)";
        PreparedStatement statement;
        while(true){
            try{
                statement = datasource.getPreparedStatement(sql);
                statement.setString(1, entity.getName());
                statement.setInt(2, entity.getGenre().getValue());
                statement.setDate(3, Date.valueOf(entity.getBirth()));
                statement.setString(4, entity.getFunction());
                statement.setString(5, entity.getSector());
                statement.executeUpdate();
            }catch(SQLException sqle){ datasource.restartConnection();}
        }
    }

    /**
     * @param entities
     * @throws SQLException
     */
    @Override
    public void insert(List<Collaborator> entities){
        for (Collaborator entity : entities)
            this.insert(entity);
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public List<Collaborator> select(){
        String sql = "SELECT * FROM collaborators;";
        List<Collaborator> entities = new ArrayList<>();
        Statement statement;
        ResultSet results;

        while(true){
            try{
                statement = datasource.getStatement();
                results = statement.executeQuery(sql);
                break;
            }catch(SQLException sqle){ datasource.restartConnection(); }
        }

        try{
            while(results.next()) {
                entities.add(new Collaborator(
                    results.getInt("id"), results.getString("name"),
                    results.getDate("birth").toLocalDate(), Genres.valueOf(results.getInt("genre")),
                    results.getString("function"), results.getString("sector")));
            }
        }catch(SQLException sqle){
            entities.clear();
        }
        
        return entities;
    }

    /**
     * 
     * @param id
     * @return
     * @throws ColaboradorNaoExistenteException
     */
    public Collaborator get(int id) throws ColaboradorNaoExistenteException{
        if (cache.containsKey(id))
            return cache.get(id);
        
        Collaborator entity;
        String sql = "SELECT (name, birth, genre, function, sector) FROM collaborators WHERE id = " + id + ";";
        Statement statement;
        while(true){
            try{
                statement = datasource.getStatement();
                ResultSet result = statement.executeQuery(sql);
                if(result.next()) {
                    entity = new Collaborator();
                    entity.setId(id);
                    entity.setName(result.getString("name"));
                    entity.setBirth(result.getDate("birth").toLocalDate());
                    entity.setGenre(Genres.valueOf(result.getInt("genre")));
                    entity.setFunction(result.getString("function"));
                    entity.setSector(result.getString("sector"));
                    return entity;
                }
            }
            catch(SQLSyntaxErrorException sqlsee){ throw new ColaboradorNaoExistenteException(id); }
            catch(SQLException sqle){ datasource.restartConnection(); }
        }
    }

    public Collaborator get(String name) throws ColaboradorNaoExistenteException{
        for(Collaborator entity : cache.values())
            if(entity.getName().equals(name))
                return entity;

        Collaborator entity = null;
        String sql = "SELECT * FROM collaborators WHERE name = " + name;
        Statement statement;
        while(true){
            try{
                statement = datasource.getStatement();
                ResultSet result = statement.executeQuery(sql);
                if(result.next()){
                    entity = new Collaborator();
                    entity.setId(result.getInt("id"));
                    entity.setName(name);
                    entity.setBirth(result.getDate("birth").toLocalDate());
                    entity.setGenre(Genres.valueOf(result.getInt("genre")));
                    entity.setSector(result.getString("sector"));
                    entity.setFunction(result.getString("function"));
                    return entity;
                }
            }
            catch(SQLSyntaxErrorException sqlsee){ throw new ColaboradorNaoExistenteException(name); }
            catch(SQLException sqle){ datasource.restartConnection(); }
        }
    }

    /**
     * @param entity
     * @return
     * @throws SQLException
     */
    @Override
    public void update(Collaborator entity){
        String sql = "UPDATE collaborators SET id = ?, name = ?, birth = ?, genre = ?, function = ?, sector = ? WHERE id = ?;";
        PreparedStatement statement;
        while(true){
            try{
                statement = datasource.getPreparedStatement(sql);
                statement.setInt(1, entity.getId());
                statement.setInt(7, entity.getId());
                statement.setString(2, entity.getName());
                statement.setDate(3, Date.valueOf(entity.getBirth()));
                statement.setInt(4, entity.getGenre().getValue());
                statement.setString(5, entity.getFunction());
                statement.setString(6, entity.getSector());
                statement.executeUpdate();
            }catch(SQLException sqle){ datasource.restartConnection(); }
        }
    }

    @Override
    public void update(List<Collaborator> entities){
        for (Collaborator entity : entities)
            this.update(entity);
    }

    @Override
    public void delete(Collaborator entity){
        String sql = "DELETE FROM collaborators WHERE id = ?;";
        PreparedStatement statement;
        while(true){
            try{
                statement = datasource.getPreparedStatement(sql);
                statement.setInt(1, entity.getId());
                statement.executeUpdate();
                break;
            }catch(SQLException sqle){ datasource.restartConnection();}
        } 
        if(cache.containsKey(entity.getId()))
            cache.remove(entity.getId());
    }

    @Override
    public void delete(List<Collaborator> entities){
        for(Collaborator entity : entities)
            this.delete(entity);
    }

}