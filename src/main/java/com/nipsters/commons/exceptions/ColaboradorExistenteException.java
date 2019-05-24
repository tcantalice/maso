package com.nipsters.commons.exceptions;

import com.nipsters.model.Collaborator;

public class ColaboradorExistenteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ColaboradorExistenteException(String nomeColaborador) {
		super("Colaborador " +nomeColaborador+ "ja exixtente!");	
	}
	
	public ColaboradorExistenteException(Collaborator collaborator) {
		this(collaborator.getName());
	}
	
}
