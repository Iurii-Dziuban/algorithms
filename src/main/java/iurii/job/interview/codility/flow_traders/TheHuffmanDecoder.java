package iurii.job.interview.codility.flow_traders;

import java.util.Map;

public class TheHuffmanDecoder {

    public String decode(Map<String, Character> symbolByEncoding, String encodedText) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = 0;
        while (end < encodedText.length()) {
            String key = encodedText.substring(start, end);
            if (symbolByEncoding.containsKey(key)) {
                result.append(symbolByEncoding.get(key));
                start = end;
            }
            end++;
        }
        return result.toString();
    }
}
