package com.nipsters.controller;

import com.nipsters.commons.commands.Command;

public enum NewCommands implements Command {

    COLLABORATOR("Colaborador", "Criar um novo colaborador"),
    ASO("Atestado", "Criar um novo ASO"),
    BACK("Voltar", "Retornar ao menu principal"){
    
    };

    private String label;
    private String desc;

    NewCommands(String label, String desc){
        this.label = label;
        this.desc = desc;
    }

    public void execute(){
        return;
    }

    public String toString() {
        return (this.label.toUpperCase() + " - " + this.desc);
    }
}