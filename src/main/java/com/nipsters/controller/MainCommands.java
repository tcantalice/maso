package com.nipsters.controller;

import com.nipsters.commons.commands.Command;

public enum MainCommands implements Command{
    NEW("Novo", "Cadastrar Colaboradores e ASOs"), 
    SEARCH("Buscar", "Opções de busca"), 
    SETTINGS("Configurações", "Todas as configurações do sistema"), 
    EXIT("Sair", "Encerra o sistema");

    private String label;
    private String desc;

    private MainCommands(String label, String desc){
        this.label = label;
        this.desc = desc;
    }

    public void execute(){}

    public String toString(){
        return (this.label.toUpperCase() + " - " + this.desc);
    }
}