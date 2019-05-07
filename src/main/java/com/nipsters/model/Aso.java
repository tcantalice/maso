package com.nipsters.model;

import java.time.LocalDate;

public class Aso {

    private long number;
    private Collaborator collaborator;
    private TypeASO type;
    private LocalDate dated;

    public Aso(){}
    
    public Aso(long number, Collaborator collaborator, TypeASO type, LocalDate dated){
        this.setNumber(number);
        this.setCollaborator(collaborator);
        this.setType(type);
        this.setDated(dated);
    }

    public void setNumber(long number){
        this.number = number;
    }

    public void setCollaborator(Collaborator collaborator){
        this.collaborator = collaborator;
    }

    public void setType(TypeASO type){
        this.type = type;
    }

    public void setDated(LocalDate dated){
        this.dated = dated;
    }

    public long getNumber(){
        return this.number;
    }

    public Collaborator getCollaborator(){
        return this.collaborator;
    }

    public TypeASO getType(){
        return this.type;
    }

    public LocalDate getDated(){
        return this.dated;
    }
}