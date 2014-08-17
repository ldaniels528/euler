package study.euler;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem #2: Find the sum of all the even-valued terms in the Fibonacci
 * sequence which do not exceed four million.
 */
public class Problem02J {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void solve() {
        final int solution = fibonacci(4000000);
        logger.info(String.format("solution = %d", solution));

        Assert.assertTrue(solution == 1089154);
    }

    /**
     * Fibonacci sequence
     * 1 + 0 = 1
     * 1 + 1 = 2
     * 2 + 1 = 3
     * 3 + 2 = 5
     */
    private int fibonacci(int max) {
        boolean done = false;
        int total = 0;
        int a = 1;
        int b = 0;

        do {
            final int sum = a + b;
            if (sum % 2 == 0) {
                if (total + sum < max) {
                    total += sum;
                    logger.info(String.format("even: %d + %d = %d", a, b, sum));
                } else done = true;
            }

            final int t = a;
            a = a + b;
            b = t;
        } while (!done);
        return total;
    }
}
