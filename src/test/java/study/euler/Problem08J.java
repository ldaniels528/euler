package study.euler;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Find the greatest sum of five consecutive digits in the 1000-digit number.
 *
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 *
 * Answer: The largest sum is 42 at position 364
 */
public class Problem08J {
    private static final String DATA_GRID =
        "73167176531330624919225119674426574742355349194934" +
        "96983520312774506326239578318016984801869478851843" +
        "85861560789112949495459501737958331952853208805511" +
        "12540698747158523863050715693290963295227443043557" +
        "66896648950445244523161731856403098711121722383113" +
        "62229893423380308135336276614282806444486645238749" +
        "30358907296290491560440772390713810515859307960866" +
        "70172427121883998797908792274921901699720888093776" +
        "65727333001053367881220235421809751254540594752243" +
        "52584907711670556013604839586446706324415722155397" +
        "53697817977846174064955149290862569321978468622482" +
        "83972241375657056057490261407972968652414535100474" +
        "82166370484403199890008895243450658541227588666881" +
        "16427171479924442928230863465674813919123162824586" +
        "17866458359124566529476545682848912883142607690042" +
        "24219022671055626321111109370544217506941658960408" +
        "07198403850962455444362981230987879927244284909188" +
        "84580156166097919133875499200524063689912560717606" +
        "05886116467109405077541002256983155200055935729725" +
        "71636269561882670428252483600823257530420752963450";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void solve() {
        String digits = null;
        int largestSum = 0;

        for( int start = 0; start < DATA_GRID.length(); start++ ) {
            // determine the end of the chunk
            final int end = start + 5;

            // extract the chunk
            final String chunk = DATA_GRID.substring( start, end <= DATA_GRID.length() ? end : DATA_GRID.length() );

            // compute the sum of each
            final int sum = computeSum(chunk);
            if( sum > largestSum ) {
                digits = chunk;
                largestSum = sum;
            }
        }

        logger.info(String.format("The largest product is %d from \"%s\" at position %d", largestSum, digits, DATA_GRID.indexOf(digits)));

        Assert.assertTrue(largestSum == 42);
    }

    /**
     * Computes the sum of the digits
     * @param digits the given string of digits (e.g. "12956")
     * @return the sum of the digits
     */
    private int computeSum(final String digits) {
        int sum = 0;
        for( final char c : digits.toCharArray()) {
            sum += ( c - '0' );
        }
        return sum;
    }

}
