package study.euler

import org.junit.Test
import org.slf4j.LoggerFactory
import java.lang.Math._

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * <p>
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * </p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * <p>
 * Answer: The Solution is: 31875000, where a = 200, b = 375, c = 425
 * </p>
 */
class Problem09() {
  private val logger = LoggerFactory.getLogger(getClass)

  @Test
  def solve() {
    findPythagoreanTriplet(1000) match {
      case Some((a, b, c)) =>
        val product = a * b * c
        logger.info(f"The Solution is: $product%.1f, where a = $a%d, b = $b%d, c = $c%.1f")
      case None =>
        throw new IllegalStateException("No match found")
    }
  }

  /**
   * Attempts to find a solution whereby a + b + c == sum
   * @param sum the given sum of a, b and c
   * @return an option of the tuple representing the triplet
   */
  private def findPythagoreanTriplet(sum: Int): Option[(Int, Int, Double)] = {
    (for {
      a <- 1 to (sum - 2)
      b <- (a + 1) to (sum - a)
      c2 = pow(a, 2) + pow(b, 2)
      c = sqrt(c2) if a + b + c == sum
    } yield (a, b, c)).headOption
  }

}