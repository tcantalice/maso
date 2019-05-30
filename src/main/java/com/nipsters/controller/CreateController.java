package com.nipsters.controller;

import com.nipsters.model.CollaboratorCRUD;

public class CreateController {
    public static void collaborator(String name, String birth, int genre, String function, String sector)
    throws IllegalArgumentException{
        CollaboratorCRUD.create(name, birth, genre, function, sector);
    }
}