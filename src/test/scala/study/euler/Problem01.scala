package study.euler

import org.junit._
import org.slf4j.LoggerFactory

/**
 * Problem #1: Add all the natural numbers below one thousand that
 * are multiples of 3 or 5.
 * 
 * Answer: 233168
 */
class Problem01() {
  val logger = LoggerFactory.getLogger(getClass)

  @Test
  def solve() {
    val solution = (1 to 999).foldLeft[Int](0) { (total, n) =>
        total + (if (n % 3 == 0 || n % 5 == 0) n else 0)
    }

    logger.info(s"solution = $solution")
    
    Assert.assertTrue(solution == 233168)
  }

}