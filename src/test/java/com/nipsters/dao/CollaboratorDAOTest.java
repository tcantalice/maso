package com.nipsters.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Ignore;
import org.junit.Test;

import com.nipsters.model.Genres;
import com.nipsters.model.Collaborator;

public class CollaboratorDAOTest {
    @Test
    @Ignore
    public void writeEntityTest(){
        try{
            System.out.println("Inserindo uma nova entidade no banco de dados");
            CollaboratorDAO.getInstance().insert(new Collaborator(
                "Tarcisio Cantalice Pereira Borges", LocalDate.of(2000, Month.JULY, 17),
                Genres.MALE, "Estagiário", "TI"));

        }catch(SQLException sqle){
            System.out.println("Inserção incompleta!");
            System.out.println(sqle.getMessage());
        }    
    }
}