package study.euler

import org.junit.Assert

/**
 * 2520 is the smallest number that can be divided by each of
 * the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest number that is evenly divisible
 * by all of the numbers from 1 to 20?
 *
 * Answer: 232792560
 */
class Problem05() {
  import org.junit.Test
  val logger = org.apache.log4j.Logger.getLogger(getClass)

  @Test
  def solve() {
    var m = 20
    while (!evenlyDivisible(m)) {
      m += 20
    }

    logger.info(s"Answer: $m")
    (1 to 20).foreach { n =>
      Assert.assertTrue(m % n == 0)
    }

    Assert.assertTrue(m == 232792560)
  }

  private def evenlyDivisible(m: Int): Boolean = {
    Seq(11, 13, 14, 15, 16, 17, 18, 19, 20) foreach { n =>
      if (m % n != 0) return false
    }
    true
  }

}