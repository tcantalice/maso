package com.nipsters.dao;

import java.util.Map;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;

import com.nipsters.model.Collaborator;
import com.nipsters.model.Genres;

public class CollaboratorDAO{

    private Map<Long, Collaborator> buff;

    private static CollaboratorDAO instance;

    private CollaboratorDAO(){
        this.buff = new HashMap<>();
    }

    public static CollaboratorDAO getInstance(){
        if(instance == null)
            instance = new CollaboratorDAO();
        return instance;
    }

    public void write(Collaborator collaborator){

    }

    public Collaborator get(long key){
        // FIXME Estruturar tratamento das exceções
        if(this.buff.containsKey(key))
            return this.buff.get(key);
        else{
            Collaborator obj = null;
            // FIXME Resolver se a conexão será feita por passagem de parâmetro ou chamada estática
            PreparedStatement sql = conn.prepareStatement("SELECT * FROM collaborators WHERE id=?");
            sql.setLong(1, key);

            ResultSet results = sql.executeQuery();
            // TODO Lançar exceção caso os atributos não sejam alocados;
            String name = results.getString("name");
            LocalDate birth = LocalDate.parse(results.getString("birth"));
            Genres genre = Genres.valueOf(results.getInt("genre"));

            obj = new Collaborator(); // FIXME Só criar o objeto caso todos os atibutos forem setados
            
            return obj; // TODO Retornar obj independente de exceções
        }
    }
}