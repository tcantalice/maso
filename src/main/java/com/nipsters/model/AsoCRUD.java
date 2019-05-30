package com.nipsters.model;

import java.time.LocalDate;

public class AsoCRUD {

    public void create(String number, String id_collab, String dated, String type){
        int paramNumber = -1;
        int paramIdCollab = -1;
        LocalDate paramDated;
        try{
            paramNumber = Integer.parseInt(number);
        }catch(NumberFormatException nfe){
            nfe = new NumberFormatException("Número ");
        }
    }

    public Aso read(){
        return null;
    }

    public Aso update(Aso aso){
        return null;
    }

    public void delete(Aso aso){

    }
}