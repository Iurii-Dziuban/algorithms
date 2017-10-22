package iurii.job.interview.codility.zooplus;

/**
 *
 *
 * https://codility.com/public-link/zooplus-AG-Java-Engineering-2016/
 *
 *
 * Created by IuriiDziuban on 10/22/17.
 */
public class TelephoneNumbersFormatter {

    public String format(String S) {
        String clearS = S.replace(" ", "").replace("-", "");
        StringBuilder result = new StringBuilder();
        if (clearS.length() <= 3) {
            return clearS;
        }
        if (clearS.length() % 3 == 1) {
            for(int i = 0; i < clearS.length() / 3 - 1; i++) {
                result.append(clearS.substring(3 * i, 3 * (i + 1)));
                result.append("-");
            }
            result.append(clearS.substring(clearS.length() - 4, clearS.length() - 2))
                    .append("-").append(clearS.substring(clearS.length() - 2));
        } else {
            for(int i = 0; i < clearS.length() / 3; i++) {
                result.append(clearS.substring(3 * i, 3 * (i + 1)));
                if((clearS.length() % 3 != 0) || (i != (clearS.length() / 3 - 1))){
                    result.append("-");
                }
                if (i == (clearS.length() / 3 - 1) && (clearS.length() % 3 != 0)) {
                    result.append(clearS.substring(clearS.length() - 2));
                }
            }
        }
        return result.toString();
    }

}
