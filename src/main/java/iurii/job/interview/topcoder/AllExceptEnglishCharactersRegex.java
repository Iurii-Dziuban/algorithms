package iurii.job.interview.topcoder;

public class AllExceptEnglishCharactersRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Remove everything except a-zA-Z characters
		String string = "ad$S!ad".replaceAll("[^a-zA-Z]", "");
		System.out.println(string);
	}

}
