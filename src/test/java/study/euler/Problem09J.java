package study.euler;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * <p/>
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p/>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * Answer: The Solution is: 31875000, where a = 200, b = 375, c = 425
 */
public class Problem09J {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void solve() {
        final int sum = 1000;

        // attempt to find the triplet
        final Triplet t = findSolution(sum);
        Assert.assertNotNull(t);

        // compute the product
        final double product = t.a * t.b * t.c;

        // report the results
        logger.info(String.format("The Solution is: %.0f, where a = %d, b = %d, c = %.0f", product, t.a, t.b, t.c));
    }

    /**
     * Attempts to find a solution whereby a + b + c == sum
     * @param sum the given sum of a, b and c
     * @return the {@link Triplet triplet}
     */
    private Triplet findSolution(final int sum) {
        for (int a = 2; a <= (sum - 2) / 3; a++) {
            for (int b = a + 1; b <= (sum - (a + 1)) / 2; b++) {
                // solve for C
                final double a2 = Math.pow(a, 2);
                final double b2 = Math.pow(b, 2);
                final double c = Math.sqrt(a2 + b2);

                // does a+b+c equal the sum?
                if (a + b + c == sum) return new Triplet(a, b, c);
            }
        }
        return null;
    }

    /**
     * A simple class for holding the triplet
     */
    public static class Triplet {
        private int a, b;
        private double c;

        public Triplet(final int a, final int b, final double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


}
