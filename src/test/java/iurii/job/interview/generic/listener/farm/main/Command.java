package iurii.job.interview.generic.listener.farm.main;

public class Command {
	
	private String commandName;
	private String animalName;
	private int periodAction = 5;
	private String stringFormat;
	
	public Command(String stringFormat){
		this.stringFormat=stringFormat;
	}
	
	public String getStringFormat() {
		return stringFormat;
	}
	
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public int getPeriodAction() {
		return periodAction;
	}
	public void setPeriodAction(int periodAction) {
		this.periodAction = periodAction;
	}
}
