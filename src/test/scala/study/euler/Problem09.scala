package study.euler

import org.junit.Test
import org.slf4j.LoggerFactory

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * 			a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * Answer: a^2 + b^2 = c^2 => 10^2 + 30^2 = 1000
 */
class Problem09() {
  val logger = LoggerFactory.getLogger(getClass)

  @Test
  def solve() {
    findSolution(1000) match {
      case Some((a, b, c2)) =>
        logger.info(s"a^2 + b^2 = c^2 => $a^2 + $b^2 = $c2")
      case None =>
        logger.info("No match found")
    }
  }

  private def findSolution(c2: Int): Option[(Int, Int, Int)] = {
    var a = 1
    var b = 1

    while (a < c2) {
      b = 1
      while (b < c2) {
        if (c2 == (Math.pow(a, 2) + Math.pow(b, 2)).intValue) return Some((a, b, c2))
        b += 1
      }
      a += 1
    }
    None
  }

}