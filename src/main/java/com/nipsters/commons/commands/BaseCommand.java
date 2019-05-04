package com.nipsters.commons.commands;
/**
	Classe abstrata do tipo 'Command'.

	Os comandos a serem criados devem estender dessa classe e reescrever o método 'execute()'.
	Dentro do método 'execute()' ficará a lógica que o comando deverá executar.
	Os comandos podem ser utilizados em dois contextos:
		Controladores: mapeiam o direcionamento de informações para outro objeto.
		Funcional: realizam uma função específica.
	Todos os comandos possuem uma etiqueta (label) utilizada como apresentação ao usuário.
	É recomendado que dentro do contexto cada comando possua uma etiqueta única e autodescritiva

	@author Tarcisio Cantalice
*/

public abstract class BaseCommand implements Command {

	protected String label;

	/**
		@param label
	*/
	protected BaseCommand(String label){
		this.label = label;
	}

	public void execute(){}

	public String toString(){
		return this.label;
	}
}