package iurii.job.interview.topcoder;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isAnagram("hellosveta", "setavelloh"));
		System.out.println(isAnagram("hellosveta", "setavelloe"));

	}
	
	private static boolean isAnagram(String standard,String test) {
		if (standard.length() != test.length()) {
			return false;
		}
		// count characters in map
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < standard.length(); i++) {
			char curChar = standard.charAt(i);
			if (!map.containsKey(curChar)) {
				map.put(curChar, 0);
			}
			Integer count = map.get(curChar) + 1;
			map.put(curChar, count);
		}
		// decrease count of equal characters in map
		for (int i = 0; i < test.length(); i++) {
			char curChar = test.charAt(i);
			if (!map.containsKey(curChar)) {
				return false;
			}
			Integer count = map.get(curChar);
			if (count.equals(0)) {
				return false;
			}
			map.put(curChar, count-1);
		}
		// check that all values in map are zero
		for (int i = 0; i < standard.length(); i++) {
			char curChar = standard.charAt(i);
			Integer count = map.get(curChar);
			if (!count.equals(0)) {
				return false;
			}
		}
		return true;
		
	}

}
