package com.nipsters.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import com.nipsters.model.Collaborator;
import com.nipsters.commons.exceptions.ColaboradorNaoExistenteException;
import com.nipsters.model.Aso;
import com.nipsters.model.CollaboratorCRUD;
import com.nipsters.model.AsoCRUD;

public abstract class SearchController{

    public static Collaborator searchCollaborator(String name) throws ColaboradorNaoExistenteException, IllegalArgumentException{
        return CollaboratorCRUD.read(name);
    }

    /* public static Aso searchAso(int number) throws UnknownEntityException {
        Aso response = null;
        response = AsoCRUD.read(number);
        return response;
    } */
}