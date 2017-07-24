package iurii.job.interview.generic.listener.farm.exceptions;

public class PropertyFormatException extends Exception {
	public void print(String s){
		System.out.println(s + "= Wrong Property format");
	}
}
