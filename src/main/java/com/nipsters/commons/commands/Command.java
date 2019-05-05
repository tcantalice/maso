package com.nipsters.commons.commands;

import java.util.List;

public interface Command{
	public void execute();
	public static Command getCommand(List<Command> commands, String input){
		for(Command cmd : commands)
			if(input.equalsIgnoreCase(commands.toString()))
				return cmd;
		return null;
	}
}