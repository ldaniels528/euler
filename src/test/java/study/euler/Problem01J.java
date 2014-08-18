package study.euler;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem #1: Add all the natural numbers below one thousand that
 * are multiples of 3 or 5.
 * <p/>
 * Answer: 233168
 */
public class Problem01J {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void solve() {
        int solution = 0;
        for (int n = 3; n < 1000; n++) {
            if ((n % 3 == 0) || (n % 5 == 0)) solution += n;
        }

        logger.info(String.format("solution = %d", solution));

        Assert.assertTrue(solution == 233168);
    }
}
