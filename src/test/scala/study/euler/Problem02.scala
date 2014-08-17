package study.euler

import org.junit.{Assert, Test}
import org.slf4j.LoggerFactory

/**
 * Problem #2: Find the sum of all the even-valued terms in the Fibonacci
 * sequence which do not exceed four million.
 */
class Problem02() {
  val logger = LoggerFactory.getLogger(getClass)

  @Test
  def solve() {
    val solution = fibonacci(max  = 4000000)
    logger.info(s"solution = $solution")

    Assert.assertTrue(solution == 1089154)
  }

  /**
   * Fibonacci sequence
   * 1 + 0 = 1
   * 1 + 1 = 2
   * 2 + 1 = 3
   * 3 + 2 = 5
   */
  def fibonacci(max: Int): Int = {
    var done = false
    var total = 0
    var a = 1
    var b = 0

    do {
      val sum = a + b
      if (sum % 2 == 0) {
        if (total + sum < max) {
          total += sum
          logger.info(s"even: $a + $b = $sum")
        } else done = true
      }

      val t = a
      a = a + b
      b = t
    } while (!done)
    total
  }

}