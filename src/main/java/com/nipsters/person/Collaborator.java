package com.nipsters.person;

import java.time.LocalDate;

public class Collaborator {
    private int id;
    private String name;
    private LocalDate birthday;
    private Genres genre;

    // Constructors
    public Collaborator(String name, LocalDate birthday, Genres genre){
        this.name = name;
        this.birthday = birthday;
        this.genre = genre;
    }

    // Getter & Setters
    public String getName(){ return this.name; }

    public String getGenre(){ return this.genre.getGenre(); }

    public void setName(String name) { this.name = name; }

    public void setGenre(Genres genre) { this.genre = genre; }

    public void setGenre(String genre) {
        if(genre.toUpperCase().charAt(0) == 'M'){ this.setGenre(Genres.MALE); }
        else if(genre.toUpperCase().charAt(0) == 'F'){ this.setGenre(Genres.FEMALE); }
    }


}
