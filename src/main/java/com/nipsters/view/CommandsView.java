package com.nipsters.view;

import java.util.List;

import com.nipsters.commons.commands.Command;
import com.nipsters.commons.io.Keyboard;

public abstract class CommandsView extends BaseView {
	
	private List<Command> commands;

	public CommandsView(String title, List<Command> commands){
		super(title);
		this.commands = commands;
		this.updateView();
	}

	public void showView(){
		Command cmd = null;
		do
			cmd = Command.getCommand(this.commands, Keyboard.getInstance().readLine());
		while(cmd == null);
		cmd.execute();
	}

	public void updateView(){
		StringBuffer commandsShow = new StringBuffer();
		for(Command command : this.commands)
			commandsShow.append(command+"\n");
		this.message = commandsShow.toString();
	}


}