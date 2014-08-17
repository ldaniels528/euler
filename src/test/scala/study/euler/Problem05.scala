package study.euler

import org.junit.Assert

/**
 * 2520 is the smallest number that can be divided by each of
 * the numbers from 1 to 10 without any remainder.
 * <p/>
 * What is the smallest number that is evenly divisible
 * by all of the numbers from 1 to 20?
 * <p/>
 * Answer: 232792560
 */
class Problem05() {

  import org.junit.Test

  val logger = org.apache.log4j.Logger.getLogger(getClass)

  @Test
  def solve() {
    var m = 20
    while (!isEvenlyDivisible(m, 2, 20)) {
      m += 20
    }

    logger.info(s"Answer: $m")
    (1 to 20).foreach { n =>
      Assert.assertTrue(m % n == 0)
    }

    Assert.assertTrue(m == 232792560)
  }

  /**
   * Determines if the given number is evenly divisible by the given range or numbers
   * @param number the given number
   * @param start the lower bound of the given range of numbers
   * @param end the upper bound of the given range of numbers
   * @return true, if the number is evenly divisible by the given range or numbers
   */
  private def isEvenlyDivisible(number: Int, start: Int, end: Int): Boolean = {
    for(n <- start to end) {
      if (number % n != 0) return false
    }
    true
  }

}