package iurii.job.interview.generic.listener.farm.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import iurii.job.interview.generic.listener.farm.exceptions.AnimalNameException;
import iurii.job.interview.generic.listener.farm.exceptions.CommandFormatException;
import iurii.job.interview.generic.listener.farm.parsers.PropertyParser;

public class Farm extends Thread {

	private TreeSet<Animal> aliveAnimals;
	private TreeSet<Animal> deadAnimals;
	private Properties classProperties;
	private BufferedWriter logFile;
	private volatile boolean isEnd = false;
	private TreeSet<Animal> dyingAnimals;

	public Farm(File pr, File f) throws IOException {
		aliveAnimals = new TreeSet<>();
		deadAnimals = new TreeSet<>();
		classProperties = (new PropertyParser()).getFileProperties(pr);
		logFile = new BufferedWriter(new FileWriter(f));
	}

	@Override
	public void run() {
		while(!isEnd){
			try {
				Thread.sleep(1000);
				dyingAnimals = new TreeSet<>();
				for(Animal an: aliveAnimals){
					if (an.isReady())
						doSomething(an);
				}
				for(Animal dAnimal: dyingAnimals){
					aliveAnimals.remove(dAnimal);
					deadAnimals.add(dAnimal);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread doesn`t sleeps");
			}
		}
		try {
			logFile.close();
		} catch (IOException e) {
			System.out.println("Log file wasn`t closed");
		}
	}

	public synchronized void doSomething(Animal an) {
		String s = an.doSomething();
		System.out.println(s);
		if (s.endsWith("died"))
		dyingAnimals.add(an);
		
		try {
			logFile.write(s+"\n");
		} catch (IOException e) {
			System.out.println("Record wasn`t added to Log file");
		}

	}

	public synchronized void executeCommand(Command com)
			throws CommandFormatException {
		if (com.getCommandName().equals("farm")) {
			if (com.getStringFormat().split(" ").length != 2)
				throw new CommandFormatException();
			if (com.getAnimalName().equals("stat")) {
				System.out.println(com.getStringFormat());
				System.out.println("Number of alive Animals="
						+ aliveAnimals.size());
				System.out.println("Types");
				TreeSet<String> typesOfAnimals = new TreeSet<String>();
				for (Animal an : aliveAnimals) {
					for (String s : classProperties.stringPropertyNames()) {
						if (an.getClass().getName().equals(
								classProperties.getProperty(s))) {
							typesOfAnimals.add(s);
						}
					}
				}
				for (String type : typesOfAnimals) {
					System.out.println(type);
				}
				System.out.println("Number of dead Animals="
						+ deadAnimals.size());
				System.out.println("Types");
				typesOfAnimals = new TreeSet<String>();
				for (Animal an : deadAnimals) {
					for (String s : classProperties.stringPropertyNames()) {
						if (an.getClass().getName().equals(
								classProperties.getProperty(s))) {
							typesOfAnimals.add(s);
						}
					}
				}
				for (String type : typesOfAnimals) {
					System.out.println(type);
				}
			} else if (com.getAnimalName().equals("close")) {
				isEnd = true;
			} else
				throw new CommandFormatException();
		} else if (com.getCommandName().equals("eat")) {
			try {
				if (com.getStringFormat().split(" ").length != 2)
					throw new CommandFormatException();
				else {
					Animal a = null;
					for (Animal cur : aliveAnimals){
						if (cur.getName().equals(com.getAnimalName()))
							a=cur;
					}
					if (a!=null){
						String action = aliveAnimals.ceiling(a).eat();
						System.out.println(action);
						try {
							logFile.write(action+"\n");
						} catch (IOException e) {
							System.out.println("Record wasn`t added to Log file");
						}
					} else
						throw new AnimalNameException();
				}
			} catch (AnimalNameException e) {
				e.print();
			} 

		} else if (com.getCommandName().equals("walk")) {
			try {
				if (com.getStringFormat().split(" ").length != 2)
					throw new CommandFormatException();
				else {
					Animal a = null;
					for (Animal cur : aliveAnimals){
						if (cur.getName().equals(com.getAnimalName()))
							a=cur;
					}
					if (a!=null){
						String action = aliveAnimals.ceiling(a).walk();
						System.out.println(action+"\n");
						try {
							logFile.write(action);
						} catch (IOException e) {
							System.out.println("Record wasn`t added to Log file");
						}
					} else
						throw new AnimalNameException();
				}
			} catch (AnimalNameException e) {
				e.print();
			} 

		} else if (com.getCommandName().equals("grow")) {
			try {
				if (com.getStringFormat().split(" ").length != 2)
					throw new CommandFormatException();
				else {
					Animal a = null;
					for (Animal cur : aliveAnimals){
						if (cur.getName().equals(com.getAnimalName()))
							a=cur;
					}
					if (a!=null){
						String action = aliveAnimals.ceiling(a).grow();
						System.out.println(action);
						try {
							logFile.write(action+"\n");
						} catch (IOException e) {
							System.out.println("Record wasn`t added to Log file");
						}
					} else
						throw new AnimalNameException();
				}
			} catch (AnimalNameException e) {
				e.print();
			} 

		} else if (com.getCommandName().equals("sleep")) {
			try {
				if (com.getStringFormat().split(" ").length != 2)
					throw new CommandFormatException();
				else {
					Animal a = null;
					for (Animal cur : aliveAnimals){
						if (cur.getName().equals(com.getAnimalName()))
							a=cur;
					}
					if (a!=null){
						String action = aliveAnimals.ceiling(a).sleep();
						System.out.println(action);
						try {
							logFile.write(action+"\n");
						} catch (IOException e) {
							System.out.println("Record wasn`t added to Log file");
						}
					} else
						throw new AnimalNameException();
				}
			} catch (AnimalNameException e) {
				e.print();
			} 

		} else if (com.getCommandName().equals("die")) {
			try {
				if (com.getStringFormat().split(" ").length != 2)
					throw new CommandFormatException();
				else {
					Animal a = null;
					for (Animal cur : aliveAnimals){
						if (cur.getName().equals(com.getAnimalName()))
							a=cur;
					}
					if (a!=null){
						Animal died = aliveAnimals.ceiling(a);
						String action = aliveAnimals.ceiling(a).die();
						deadAnimals.add(died);
						aliveAnimals.remove(died);
						System.out.println(action);
						try {
							logFile.write(action+"\n");
						} catch (IOException e) {
							System.out.println("Record wasn`t added to Log file");
						}
					} else
						throw new AnimalNameException();
				}
			} catch (AnimalNameException e) {
				e.print();
			} 

		} else if (classProperties.containsKey(com.getCommandName())) {
			try {
				Animal a = (Animal) Class.forName(
						classProperties.getProperty(com.getCommandName()))
						.newInstance();
				Pattern pat = Pattern.compile("[a-zA-Z]+[0-9]*");
				Matcher mat = pat.matcher(com.getAnimalName());
				if (mat.matches()) {
					a.setName(com.getAnimalName());
					if (aliveAnimals.contains(a)) {
						System.out.println("Animal with this name exists");
					} else if (deadAnimals.contains(a))
						System.out.println("Animal with this name is dead");
					else if (com.getPeriodAction() < 5)
						System.out.println("Bad Period Time");
					else {
						a.setPeriodAction(com.getPeriodAction());
						DateFormat df = new SimpleDateFormat("HH:mm:ss");
						String record = df.format(new Date()) + "-"
								+ com.getCommandName() + " " + a.getName()
								+ " created";
						System.out.println(record);
						try {
							logFile.write(record + "\n");
						} catch (IOException e) {
							System.out.println("Something wrong with log file");
						}
						this.aliveAnimals.add(a);
					}

				} else
					throw new AnimalNameException();
			} catch (InstantiationException e) {
				System.out.println("No such type of animal");
			} catch (IllegalAccessException e) {
				System.out.println("No such type of animal");
			} catch (ClassNotFoundException e) {
				System.out.println("No such type animal");
			} catch (AnimalNameException e) {
				e.print();
			}
		} else {
			throw new CommandFormatException();
		}
	}

}
