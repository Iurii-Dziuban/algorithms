package iurii.job.interview.codility.zalando;

import java.util.Objects;
import java.util.stream.Stream;

/**
 *  Codility Zalando Coding Challenge
 */
public class ZalandoHiringEvent {

    /**
     * Write a function, that given an array A of N integers (between -100 and 100),
     * returns the sign (-1, 0, 1) of the product of all the numbers
     * in the array multiplied together.
     * Assume that N is between 1 and 1000
     *
     * For example:
     * Example test:   [1, -2, -3, 5]
     * Returned value: 1
     *
     * Example test:   [1, 2, 3, -5]
     * Returned value: -1
     *
     * Example test:   [1, 2, 0, -5]
     * Returned value: 0
     *
     * @param A array
     * @return -1, 0 or 1 sign of all A elements product
     */
    public int solution1(int[] A) {
        int result = 1;
        for(int num : A) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                result = -result;
            }
        }
        return result;
    }

    /**
     * You are working as a tester in a factory. Your goal is to implement a
     * ProductionLineTester.test() method which accepts a Stream<Product> as
     * an argument and returns a ProductLineTestReport :
     *
     * class ProductLineTestReport {
     *     long correctCnt;       // number of correct products
     *     long checkedExcCnt;    // number of products which threw a checked exception
     *     long uncheckedExcCnt;  // number of products which threw an unchecked exception
     *     long otherExcCnt;      // number of products which threw an error during execution
     *
     *     public ProductLineTestReport(long correctCnt, long checkedExcCnt, long uncheckedExcCnt, long otherExcCnt) {
     *         this.correctCnt = correctCnt;
     *         this.checkedExcCnt = checkedExcCnt;
     *         this.uncheckedExcCnt = uncheckedExcCnt;
     *         this.otherExcCnt = otherExcCnt;
     *     }
     * }
     *
     * To test a Stream<Product> (order is important!) you must:
     * - filter out all <null/> values;
     * - filter out all Product instances whose status field of type String is
     * equal to "invalid" (the comparison should be case insensitive and
     * Product follows JavaBeans conventions);
     * - ignore the first 10 products;
     * - restrict processing to 20 products;
     * - call ProductVerifier.verify (Product) for each product
     *
     * Unfortunately, Product.verify(Product) is marked as void, and if
     * the product is invalid it throws a checked exception or an unchecked exception,
     * or even an Error. The ProductVerifier interface is defined as follows:
     *
     * interface ProductVerifier {
     *     void verify(Product product) throws Exception;
     * }
     *
     * Your goal is to count how many:
     * - checked exceptions were thrown;
     * - unchecked exceptions were thrown;
     * - Errors were thrown;
     * - correct products were in the line;
     * and return an instance of ProductLineTestReport.
     *
     * Also, whatever argument you get as input to ProductionLineTester.test()
     * (null, empty Stream and so on), you must not return null -
     * return an empty report in such a case. An empty report is a report with all
     * *Counter values set to 0 (zero).
     */
    class ProductionLineTester {

        private final ProductVerifier verifier;

        ProductionLineTester(ProductVerifier verifier) {
            this.verifier = verifier;
        }

        ProductLineTestReport test(Stream<Product> products) {
            if (products == null) {
                return new ProductLineTestReport(0,0,0,0);
            }
            TempResult r = new TempResult();
            products
                .filter(Objects::nonNull)
                .filter(p -> p.getStatus() == null || !"invalid".equalsIgnoreCase(p.getStatus()))
                .skip(10)
                .limit(20)
                .forEach(p -> check(p, r));

            return toReport(r);
        }

        private void check(Product p, TempResult r) {
            try {
                verifier.verify(p);
                r.correctCnt++;
            } catch (RuntimeException e) {
                r.uncheckedExcCnt++;
            } catch (Exception e) {
                r.checkedExcCnt++;
            } catch (Error e) {
                r.otherExcCnt++;
            }
        }

        private class TempResult {
            long correctCnt = 0;
            long checkedExcCnt = 0;
            long uncheckedExcCnt = 0;
            long otherExcCnt = 0;
        }

        private ProductLineTestReport toReport(TempResult r) {
            return new ProductLineTestReport(r.correctCnt, r.checkedExcCnt, r.uncheckedExcCnt, r.otherExcCnt);
        }

        // Defined part
        private class ProductLineTestReport {
            long correctCnt;
            long checkedExcCnt;
            long uncheckedExcCnt;
            long otherExcCnt;

            public ProductLineTestReport(long correctCnt, long checkedExcCnt, long uncheckedExcCnt, long otherExcCnt) {
                this.correctCnt = correctCnt;
                this.checkedExcCnt = checkedExcCnt;
                this.uncheckedExcCnt = uncheckedExcCnt;
                this.otherExcCnt = otherExcCnt;
            }
        }

        private class ProductVerifier {
            public void verify(Product p) {
                // some code
            }
        }

        private class Product {
            private String status;
            // some more fields

            public String getStatus() {
                return status;
            }
        }
    }

    /**
     * There are N nails hammered into the same block of wood.
     * Each nail sticks out of the wood at some length.
     * You can choose at most K nails and hammer them down
     * to any length between their original lengths and 0.
     * Nails can not be pulled up.
     * The goal is to have as many nails of the same length as possible.
     *
     * You are given an implementation of a functionL
     * int solutionBefore(int[] A, int K);
     * which, given an array A of N integers representing lengths of the nails
     * sorted in a non-decreasing order and an integer K,
     * returns the maximum number of nails
     * that can be positioned at the same length
     * after hammering down at most K nails.
     *
     * For example, given K = 2 and array  [1, 1, 3, 3, 3, 4, 5, 5, 5, 5]
     * the function should return 5. One of the possibilities is to hammer the nails
     * represented by A[8] and A[9] down to length 3.
     *
     * 5             _ _ _ _
     * 4           _ | | | |
     * 3     _ _ _ | | | | | <------- 3
     * 2     | | | | | | | |
     * 1 _ _ | | | | | | | |
     * 0 | | | | | | | | | |
     *   0 1 2 3 4 5 6 7 8 9
     *
     * The attached code is still incorrect for some inputs.
     * Despite the error(s), the code may produce a correct
     * answer for the example test cases.
     * The goal of the exercise is to find and fix the bug(s)
     * in the implementation.
     * You can modify at most four lines.
     *
     * Assume that:
     * - N is an integer within the range [1..10000];
     * - K is an integer within the range [0..N];
     * - each element of array A is an integer within the range
     * [1.. 1000000000];
     * - array A is sorted in non-decreasing order.
     *
     * Example test:   ([1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 2)
     * Returned value: 5
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 10]
     * Returned value: 10
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 0]
     * Returned value: 4
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 9]
     * Returned value: 10
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 8]
     * Returned value: 10
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 7]
     * Returned value: 9
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 6]
     * Returned value: 8
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 5]
     * Returned value: 8
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 4]
     * Returned value: 7
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 3]
     * Returned value: 6
     *
     * Your test case: [[1, 1, 3, 3, 3, 4, 5, 5, 5, 5], 1]
     * Returned value: 4
     *
     */
    // initial solution with bugs
    int solutionBefore(int[] A, int K) {
        int n = A.length;
        int best = 0;
        int count = 1;
        for (int i = 0; i < n - K - 1; i++) {
            if (A[i] == A[i + 1])
                count = count + 1;
            else
                count = 0;
            if (count > best)
                best = count;
        }
        int result = best + 1 + K;
        return result;
    }

    // modified solution
    int solutionAfter(int[] A, int K) {
        int n = A.length;
        int best = 0;
        int count = 1;
        for (int i = 0; i < n - K - 1; i++) {
            if (A[i] == A[i + 1])
                count = count + 1;
            else
                count = 1;
            if (count > best)
                best = count;
        }
        int result = (K >= n-1) ? n : (best + K);
        return result;
    }
}
