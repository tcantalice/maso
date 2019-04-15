package com.nipsters.aso;

public enum AsoTypes {
    PERI("Periódico"), ADMI("Admissional"), DISM("Demissional"), CHG_FUN("Mudança de Função");

    private String value;

    private AsoTypes(String value){
        this.value = value;
    }

    public String getType(){ return this.value; }
}
