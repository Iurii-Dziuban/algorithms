package iurii.job.interview.amazon.online_assesment;

import java.util.Objects;

/**
 * Question which is asked on Online interview assessments.
 * Is a part of Amazon Code Review training.
 * Links where I found that question and potential solutions :
 * - Leetcode discussion : https://leetcode.com/discuss/interview-question/1008283/amazon-oa-sde-1-fresh-promotion
 * - Youtube example of question and solution : https://www.youtube.com/watch?v=PBBEehnUW_8&ab_channel=crazydevelopers
 * - Example of Youtube solution on Github with test cases : https://github.com/crazy-developers-dev/AmazonOA/blob/master/P1_AmazonFreshPromotion.java
 */
public class AmazonFreshPromotion {

    public boolean match(String[][] codeList, String[] shoppingCart) {
        // check conditions ex. not empty
        if (codeList == null || codeList.length == 0) {
            return false;
        }
        if (shoppingCart == null || shoppingCart.length == 0) {
            return false;
        }
        // scan while matching
        int codeListSize = codeList.length;
        int shoppingCartSize = shoppingCart.length;

        int codeListIndex = 0;
        int shoppingCartIndex = 0;

        // algo in a couple of words - 2 pointer subarray check on matching
        // one pointer - position in shopping cart
        // second pointer current code to match from codeList

        while (shoppingCartIndex < shoppingCartSize && codeListIndex < codeListSize) {
            String[] currentCode = codeList[codeListIndex];
            boolean isMatch = match(currentCode, shoppingCart, shoppingCartIndex);
            if (!isMatch) {
                // try match from next one
                shoppingCartIndex++;
            } else {
                // if match - continue from next index after match
                shoppingCartIndex += currentCode.length;
                codeListIndex++;
            }

            if (codeListIndex == codeListSize) {
                // all codes are matched
                return true;
            }
        }

        return false;
    }

    private boolean match(String[] code, String[] shoppingCart, int shoppingCartStartIndex) {
        // no left items to match
        if (shoppingCartStartIndex + code.length > shoppingCart.length) {
            return false;
        }
        for (int codeIndex= 0; codeIndex < code.length; codeIndex++) {
            String codeValue = code[codeIndex];
            if ("anything".equals(codeValue)) {
                // match - check next
                continue;
            }
            if (!Objects.equals(shoppingCart[shoppingCartStartIndex + codeIndex], codeValue)) {
                // no match
                return false;
            }
        }
        // all codes match
        return true;
    }
}
