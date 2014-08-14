package study.euler

import org.junit.{Assert, Test}
import org.slf4j.LoggerFactory

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * Answer: The sum of primes < 2000000 is 142913828922
 */
class Problem10() {
  private val logger = LoggerFactory.getLogger(getClass)

  @Test
  def solve() {
    val maxValue = 2000000
    val sumOfPrimes = getSumOfPrimes(maxValue)
    logger.info(s"The sum of primes < $maxValue is $sumOfPrimes")

    Assert.assertTrue(sumOfPrimes == 142913828922L)
  }

  private def getSumOfPrimes(maxValue: Int): Long = {
    var sum = 0L
    var n = 2
    while (n < maxValue) {
      if (isPrime(n)) {
        sum += n
      }
      n += 1
    }
    sum
  }

  private def isPrime(number: Long): Boolean = {
    var m = 2L
    while (m <= number / m) {
      if (number % m == 0) {
        return false
      }
      m += 1
    }
    true
  }

}