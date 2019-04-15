package com.nipsters.person;

public enum Genres {
    MALE("Masculino"), FEMALE("Feminino");

    private String value;
    private char initial;

    private Genres(String value){
        this.value = value;
        this.initial = value.charAt(0);
    }

    public String getGenre(){
        return this.value;
    }

}
