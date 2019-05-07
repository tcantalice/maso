package com.nipsters.model;

public enum TypeASO {
    ADMISSIONAL(1, "Admissional"), 
    DEMISSIONAL(2, "Demissional"), 
    PERIODIC(3, "Priódico"), 
    CHANGE_FUNCTION(4, "Mudança de Função");

    private int value;
    private String label;

    private TypeASO(int value, String label){
        this.value = value;
        this.label = label;
    }

    /**
     * 
     * @param value Um número identificador do tipo de ASO
     * @return O tipo de ASO referente ao valor numérico, ou null caso não haja referência
     */
    public static TypeASO valueOf(int value){
        for(TypeASO type : TypeASO.values())
            if(type.getValue() == value)
                return type;
        return null;
    }

    public int getValue(){
        return this.value;
    }

    public String getLabel(){
        return this.label;
    }
}