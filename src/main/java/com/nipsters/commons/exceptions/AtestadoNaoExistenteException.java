package com.nipsters.commons.exceptions;

import com.nipsters.model.Aso;

public class AtestadoNaoExistenteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AtestadoNaoExistenteException(int Atestado) {
		super("Atestado " +Atestado+ " não existente!");
	}
	
	public AtestadoNaoExistenteException(Aso atestado) {
		this(atestado.getNumber());
	}

}
