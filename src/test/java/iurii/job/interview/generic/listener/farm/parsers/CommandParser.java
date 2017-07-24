package iurii.job.interview.generic.listener.farm.parsers;

import iurii.job.interview.generic.listener.farm.exceptions.CommandFormatException;
import iurii.job.interview.generic.listener.farm.main.Command;

public class CommandParser {
	static public Command parseCommand(String commandLine) throws CommandFormatException, NumberFormatException{
		Command command = new Command(commandLine);
		String [] parameters = commandLine.split(" ");
		if ((parameters.length<1)||(parameters.length>3))
			throw new CommandFormatException();
		switch (parameters.length){
		    case 3: command.setPeriodAction(Integer.valueOf(parameters[2]));
		    case 2: command.setAnimalName(parameters[1]);
		    case 1: command.setCommandName(parameters[0]);
		}
		return command;
	} 

}
