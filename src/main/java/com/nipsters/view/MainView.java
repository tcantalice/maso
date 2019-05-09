package com.nipsters.view;

import com.nipsters.controller.MainCommands;

public class MainView extends CommandsView {

    private static View instance;

    private MainView(){
        super("Menu Principal", MainCommands.values());
    }

    public static View getInstance(){
        if(instance == null)
            instance = new MainView();
        return instance;
    }
}