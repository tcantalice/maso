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

    /**
     * 
     * @param name
     * @param birth
     * @param genre
     * @param function
     * @param sector
     */
    public Collaborator(String name, LocalDate birth, Genres genre, String function, String sector){
        this.setName(name);
        this.setBirth(birth);
        this.setGenre(genre);
        this.setFunction(function);
        this.setSector(sector);
    }

    /**
     * 
     * @param id
     * @param name
     * @param birth
     * @param genre
     * @param function
     * @param sector
     */
    public Collaborator(int id, String name, LocalDate birth, Genres genre, String function, String sector){
        this(name, birth, genre, function, sector);
        this.setId(id);
    }
    
    /**
     * 
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 
     * @param birth
     */
    public void setBirth(LocalDate birth){
        this.birth = birth;
    }

    /**
     * 
     * @param genre
     */
    public void setGenre(Genres genre){
        this.genre = genre;
    }

    /**
     * 
     * @param function
     */
    public void setFunction(String function){
        this.function = function;
    }

    /**
     * 
     * @param sector
     */
    public void setSector(String sector){
        this.sector = sector;
    }

    /**
     * 
     * @return
     */
    public int getId(){
        return this.id;
    }

    /**
     * 
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * 
     * @return
     */
    public LocalDate getBirth(){
        return this.birth;
    }

    /**
     * 
     * @return
     */
    public Genres getGenre(){
        return this.genre;
    }

    /**
     * 
     * @return
     */
    public String getFunction(){
        return this.function;
    }

    /**
     * 
     * @return
     */
    public String getSector(){
        return this.sector;
    }
}