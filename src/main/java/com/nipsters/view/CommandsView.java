package com.nipsters.view;

import com.nipsters.commons.commands.Command;
import com.nipsters.commons.io.Keyboard;

public abstract class CommandsView extends BaseView {
	
	protected Command[] commands;

	public CommandsView(String title, Command[] commands){
		super(title);
		this.commands = commands;
		this.updateView();
	}

	public void showView(){
		Command cmd = null;
		do{
			super.showView();
			System.out.print(">> ");
			try{
				cmd = this.commands[Keyboard.getInstance().readInt() - 1];
			}
			catch(IndexOutOfBoundsException ie){
				// TODO Emissão de avisos e erros
				System.out.print("\n[AVISO] - Comando inválido! Utilize um dos comandos listados.\n\n");
			}
		}while(cmd == null);
		cmd.execute();
	}

	public void updateView(){
		StringBuffer commandsShow = new StringBuffer();
		int indexCommand = 0;
		for(Command command : this.commands){
			commandsShow.append((indexCommand + 1) + " - " + command + "\n");
			indexCommand++;
		}
		this.message = commandsShow.toString();
	}

}