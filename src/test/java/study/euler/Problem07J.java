package study.euler;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 * <p/>
 * What is the 10001st prime number?
 * <p/>
 * Answer: The 1001st prime is 7927
 */
public class Problem07J {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void problem7() {
        int lastPrime = 1;
        int index = 0;
        int count = 1001;

        while (index < count) {
            int prime = lastPrime + 1;
            while (!isPrime(prime)) {
                prime++;
            }
            lastPrime = prime;
            index++;
        }

        logger.info(String.format("The %dth prime number is %d", count, lastPrime));

        Assert.assertTrue(lastPrime == 7927);
    }

    /**
     * Determines whether the given number is a prime number
     *
     * @param number the given number
     * @return true, if the number is a prime number (e.g. 2, 3, 5, 7, ...)
     */
    private boolean isPrime(final long number) {
        // fail-sage
        if (number < 2) {
            return false;
        }

        for (long n = 2; n <= number / n; n++) {
            if (number % n == 0) return false;
        }
        return true;
    }

}
