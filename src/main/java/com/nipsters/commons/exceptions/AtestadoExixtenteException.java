package com.nipsters.commons.exceptions;

import com.nipsters.model.Aso;

public class AtestadoExixtenteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AtestadoExixtenteException(int CodigoAtestado) {
		super("Atestado " +CodigoAtestado+ " Ja existente para colaborador!");
	}
	
	public AtestadoExixtenteException(Aso atestado) {
		this(atestado.getNumber());
	}

}
