package com.nipsters.model;

import java.time.LocalDate;

import com.nipsters.commons.dates.DataControl;
import com.nipsters.commons.exceptions.ColaboradorNaoExistenteException;
import com.nipsters.dao.CollaboratorDAO;

public class CollaboratorCRUD {
    public static void create(String name, String birth, int genre, String function, String sector)
    throws IllegalArgumentException{
        if(name.isEmpty() || name == null)
            throw new IllegalArgumentException("Campo \"Nome\" é obrigatório");
        if(birth.isEmpty() || birth == null)
            throw new IllegalArgumentException("Campo \"Data de Nascimento\" é obrigatório");
        if(function.isEmpty() || function == null)
            throw new IllegalArgumentException("Campo \"Função\" é obrigatório");
        if(sector.isEmpty() || sector == null)
            throw new IllegalArgumentException("Campo \"Setor\" é obrigatório");
        
        Collaborator obj = new Collaborator();
        // Prevents invalid date
        try{ obj.setBirth(DataControl.formatData(birth)); }
        catch(IllegalArgumentException iae){ throw new IllegalArgumentException("Data de nascimento inválida"); }

        obj.setName(name);
        obj.setGenre(Genres.valueOf(genre));
        obj.setFunction(function);
        obj.setSector(sector);
        
        CollaboratorDAO.getInstance().insert(obj);
    }

    public static Collaborator read(String name) throws ColaboradorNaoExistenteException, IllegalArgumentException {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Por favor, informe o nome do colaborador!");
        
        return CollaboratorDAO.getInstance().get(name);
    }
    
}