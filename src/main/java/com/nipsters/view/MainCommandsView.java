package com.nipsters.view;

import com.nipsters.controller.MainCommands;

public class MainCommandsView extends CommandsView {

    private static MainCommandsView instance;

    private MainCommandsView(){
        super("Menu principal", MainCommands.values());
    }

    public static MainCommandsView getInstance(){
        if(instance == null){
            instance = new MainCommandsView();
        }
        return instance;
    }

}