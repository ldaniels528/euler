package study.euler;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem #4: A palindromic number reads the same both ways. The largest
 * palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
 * <p/>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * <p/>
 * Answer: The largest palindrome is 906609 = 913 x 993.
 */
public class Problem04J {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void problem4() {
        int max = 0;
        int n1 = 0;
        int n2 = 0;

        for (int n = 999; n > 99; n--) {
            for (int m = 999; m > 99; m--) {
                final int number = n * m;
                if (number > max) {
                    final StringBuilder s = new StringBuilder(String.valueOf(number));
                    if (s.toString().equals(s.reverse().toString())) {
                        max = number;
                        n1 = n;
                        n2 = m;
                    }
                }
            }
        }

        logger.info(String.format("The largest palindrome is %s (%d x %d)", max, n1, n2));
    }

}
