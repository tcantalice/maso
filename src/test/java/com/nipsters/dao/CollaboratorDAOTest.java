package com.nipsters.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.nipsters.model.Genres;
import com.nipsters.commons.dates.DataControl;
import com.nipsters.commons.exceptions.ColaboradorNaoExistenteException;
import com.nipsters.model.Collaborator;

public class CollaboratorDAOTest {
    static Collaborator collabTest;

    static String name;
    static LocalDate birth;
    static Genres genre;
    static String function;
    static String sector;

    @BeforeClass
    public static void initValues(){
        System.out.println("Inicializando valores de teste...");
        name = "Tarcisio Cantalice Pereira Borges";
        birth = DataControl.formatData("17/07/2000");
        genre = Genres.MALE;
        function = "Estagirário";
        sector = "TI";
        System.out.println("Instanciando objeto...");
        collabTest = new Collaborator(name, birth, genre, function, sector);
    }

    
    @Test
    @Ignore
    public void writeEntityTest(){
        System.out.println("Teste inserção...");
        try{
            CollaboratorDAO.getInstance().insert(collabTest);
            System.out.println("Inserção funcionou!");
        }catch(SQLException sqle){
            System.out.println("Inserção falhou!");
        }    
    }

    @Test
    @Ignore
    public void selectEntityTest(){
        System.out.println("Teste de seleção...");
        CollaboratorDAO.getInstance().select();
        System.out.println("Registros recuperados com sucesso!");
    }

    @Test
    @Ignore
    public void updateEntityTest(){
        System.out.println("Teste de atualização...");
        collabTest.setName("Borges Pereira Cantalice Tarcisio");
        
        try{
            CollaboratorDAO.getInstance().update(collabTest);
            System.out.println("Atualização de registro realizada com sucesso!");
        }catch(SQLException sqle){
            System.out.println("Atualização de registro falhou!");
        }
    }

    @Test
    @Ignore
    public void deleteEntityTest(){
        System.out.println("Teste de remoção...");
        try{
            CollaboratorDAO.getInstance().delete(collabTest);
            System.out.println("Registro removido com sucesso!");
        }catch(SQLException sqle){
            System.out.println("Remoção do registro falhou!");
        }
    }

    @Test
    public void getByNameTest(){
        try{
            CollaboratorDAO.getInstance().get("ABC");
        }catch(ColaboradorNaoExistenteException cnee){
            throw new AssertionError(cnee.getMessage());
        }
    }
}