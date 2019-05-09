package com.nipsters.view;

import com.nipsters.controller.NewCommands;

public class NewView extends CommandsView {
    
    private static View instance;

    public NewView(){
        super("Novo", NewCommands.values());
    }

    public static View getInstance(){
        if(instance == null)
            instance = new NewView();
        return instance;
    }
}