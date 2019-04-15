package com.nipsters.aso;

import java.time.LocalDate;

import com.nipsters.person.Collaborator;

public class ASO {
    private int number;
    private Collaborator collaborator;
    private AsoTypes type;
    private LocalDate date;

    public ASO(Collaborator collaborator){
        this.collaborator = collaborator;
    }
}
