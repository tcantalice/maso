package com.nipsters.model;

import java.time.LocalDate;

public class Collaborator {

    private int id;
    private String name;
    private LocalDate birth;
    private Genres genre;
    private String function;
    private String sector;

    /*
        Constructors
    */

    public Collaborator(){}

    public Collaborator(String name, LocalDate birth, Genres genre, String function, String sector){
        this.setName(name);
        this.setBirth(birth);
        this.setGenre(genre);
        this.setFuction(function);
        this.setSector(sector);
    }

    public Collaborator(int id, String name, LocalDate birth, Genres genre, String function, String sector){
        this(name, birth, genre, function, sector);
        this.setId(id);
    }

    /*
        Getters & Setters
    */

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirth(LocalDate birth){
        this.birth = birth;
    }

    public void setGenre(Genres genre){
        this.genre = genre;
    }

    public void setFuction(String function){
        this.function = function;
    }

    public void setSector(String sector){
        this.sector = sector;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getBirth(){
        return this.birth;
    }

    public Genres getGenre(){
        return this.genre;
    }

    public String getFunction(){
        return this.function;
    }

    public String getSector(){
        return this.sector;
    }
}