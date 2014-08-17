package study.euler;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2520 is the smallest number that can be divided by each of
 * the numbers from 1 to 10 without any remainder.
 * <p/>
 * What is the smallest number that is evenly divisible
 * by all of the numbers from 1 to 20?
 * <p/>
 * Answer: 232792560
 */
public class Problem05J {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void problem5() {
        int number = 2520;
        while (!isEvenlyDivisible(number, 2, 20)) {
            number++;
        }

        logger.info(String.format("The number is %d", number));

        Assert.assertTrue(number == 232792560);
    }

    /**
     * Determines if the given number is evenly divisible by the given range or numbers
     *
     * @param number the given number
     * @param start  the lower bound of the given range of numbers
     * @param end    the upper bound of the given range of numbers
     * @return true, if the number is evenly divisible by the given range or numbers
     */
    private boolean isEvenlyDivisible(final int number, final int start, final int end) {
        for (int n = start; n <= end; n++) {
            if (number % n != 0) {
                return false;
            }
        }
        return true;
    }

}
