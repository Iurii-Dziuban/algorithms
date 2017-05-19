package iurii.job.interview.topcoder.srm468;

import java.util.*;
public class T9 {
    
    public static void main(String[] args) {
        new T9().message(new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}, new String[]{"bad"}, new String[] {"2230223"});
    }
    
    public String message(String[] part, String[] dict, String[] keystr) {
        String keystroke = "";
        for (String keystrItem : keystr) {
            keystroke += keystrItem;
        }
        keystroke = keystroke.replace("#", "");
        keystroke = keystroke.replace("*", "");
        String[] words = keystroke.split("0");
        String result = "";
        for (String word : words) {
            String decoded = decode(word, part, dict);
            result += decoded + " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
    
    private String decode(String word, String[] part, String[] dict) {
        List<String> variants = getVariants(word, part, dict);
        for (String variant : variants) {
            for (String dictWord : dict) {
                if (variant.equals(dictWord)) {
                    return variant;
                }
            }
        }
        return "";
    }
    
    private List<String> getVariants(String word, String[] part, String[] dict) {
        List<String> result = new ArrayList<String>();
        if (word.length() == 0) {
            result.add("");
            return result;
        }
        List<String> variants = getVariants(word.substring(1), part, dict);
        int number = Integer.valueOf("" + word.charAt(0)) - 1;
        for (int i = 0; i < part[number].length(); i++) {
            for (String variant : variants) {
                result.add(part[number].charAt(i) + variant);
            }
        }
        return result;
    }
}
