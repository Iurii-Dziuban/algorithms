package iurii.job.interview.generic.listener.farm.main;

import iurii.job.interview.generic.listener.farm.exceptions.CommandFormatException;
import iurii.job.interview.generic.listener.farm.exceptions.CommandLineParametersException;
import iurii.job.interview.generic.listener.farm.parsers.CommandParser;
import iurii.job.interview.generic.listener.farm.parsers.PropertyParser;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try {
			Properties mainProp = (new PropertyParser().getCommandLineProperties(args));
			Farm farm = new Farm(new File(mainProp.getProperty("-f")), new File(mainProp.getProperty("-log")));
			farm.start();
			String commandLine= "";
			do {
				try {
				    Scanner scanner = new Scanner(System.in);
				    commandLine = scanner.nextLine();
				    Command command = CommandParser.parseCommand(commandLine);
				    farm.executeCommand(command);
				} catch(NumberFormatException ex){
					System.out.println("Wrong period of time parameter");
				} catch (CommandFormatException e) {
					e.print();
				}
			}
			while (!commandLine.equals("farm close"));
		} catch (CommandLineParametersException ex) {
			ex.print();
		}  catch(IOException ex){
			System.out.println("Wrong names of files");
		}
	}

}
