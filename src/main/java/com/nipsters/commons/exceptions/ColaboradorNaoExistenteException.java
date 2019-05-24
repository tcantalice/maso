package com.nipsters.commons.exceptions;

import com.nipsters.model.Collaborator;

public class ColaboradorNaoExistenteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ColaboradorNaoExistenteException(String nomeColaborador) {
		super("Colaborador " +nomeColaborador+ "não existente!");	
	}
	
	public ColaboradorNaoExistenteException(Collaborator collaborator) {
		this(collaborator.getName());
	}
	
}
