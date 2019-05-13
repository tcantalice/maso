package com.nipsters.model;

public enum Genres {
    FEMALE(0, "Feminino"), MALE(1, "Masculino");

    private int value;
    private String label;

    private Genres(int value, String label){
        this.value = value;
        this.label = label;
    }

    public int getValue(){
        return this.value;
    }

    public String getLabel(){
        return this.label;
    }

    /**
     * 
     * @param value
     * @return
     */
    public static Genres valueOf(int value){
        for(Genres genre : Genres.values())
            if(genre.getValue() == value)
                return genre;
        return null;
    }
}