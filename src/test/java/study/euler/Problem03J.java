package study.euler;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem #3: The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Answer: The largest prime is 6857
 */
public class Problem03J {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void solve() {
        final long num = 600851475143L;
        Long max = null;

        for (long n = 2; n < num / n; n++) {
            if ((num % n == 0) && isPrime(n)) {
                max = n;
            }
        }

        logger.info(String.format("The largest prime factor of %d is %d", num, max));
    }

    /**
     * Determines whether the given number is a prime number
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
