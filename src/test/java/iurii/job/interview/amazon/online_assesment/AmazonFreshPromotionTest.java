package iurii.job.interview.amazon.online_assesment;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmazonFreshPromotionTest {

    @Test
    public void testMatch() {
        AmazonFreshPromotion amazonFreshPromotion = new AmazonFreshPromotion();

        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};

        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};

        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};

        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};


        assertThat(amazonFreshPromotion.match(codeList1, shoppingCart1)).isTrue();
        assertThat(amazonFreshPromotion.match(codeList2, shoppingCart2)).isFalse();
        assertThat(amazonFreshPromotion.match(codeList3, shoppingCart3)).isFalse();
        assertThat(amazonFreshPromotion.match(codeList4, shoppingCart4)).isFalse();
    }
}