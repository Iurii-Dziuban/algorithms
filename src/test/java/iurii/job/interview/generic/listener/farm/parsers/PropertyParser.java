package iurii.job.interview.generic.listener.farm.parsers;

import iurii.job.interview.generic.listener.farm.exceptions.CommandLineParametersException;
import iurii.job.interview.generic.listener.farm.exceptions.PropertyFormatException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyParser {

	public Properties getFileProperties(File file) throws IOException {
		Properties properties = new Properties();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] property = new String[2];
			try {
				property = line.split("=");
				if (property.length != 2) {
					throw new PropertyFormatException();
				}
				Class.forName(property[1]).newInstance();
				properties.setProperty(property[0], property[1]);
			} catch (PropertyFormatException ex) {
				ex.print(line);
			} catch (Exception ex) {
				System.out.println(property[1] + " not found");
			}
		}
		return properties;
	}

	public Properties getCommandLineProperties(String[] args)
			throws CommandLineParametersException {
		Properties properties = new Properties();
		if (args.length != 2) {
			throw new CommandLineParametersException();
		}
		String[] firstParameter = args[0].split("=");
		String[] secondParameter = args[1].split("=");
		if ((firstParameter.length != 2)
				|| (secondParameter.length != 2)
				|| (!firstParameter[0].equals("-f"))
				|| (!secondParameter[0].equals("-log"))
				|| (!firstParameter[1].endsWith(".properties") || (!secondParameter[1].endsWith(".log")))) {
			throw new CommandLineParametersException();
		}
		properties.setProperty(firstParameter[0], firstParameter[1]);
		properties.setProperty(secondParameter[0], secondParameter[1]);
		return properties;
	}

}
