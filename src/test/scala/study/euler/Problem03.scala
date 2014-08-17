package study.euler

import org.junit._
import org.slf4j.LoggerFactory

/**
 * Problem #3: The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * Answer: The largest prime is 6857
 */
class Problem03() {
  val logger = LoggerFactory.getLogger(getClass())

  @Test
  def solve() {
    val largePrime = 600851475143L

    val result = largestPrime(largePrime)
    result match {
      case Some(factor) =>
        logger.info(s"The largest prime factor of $largePrime is ${factor}")
      case None =>
        logger.info(s"No factor could be found; $largePrime is a prime.")
    }
    
    Assert.assertTrue(result == Some(6857))
  }

  /**
   * Finds the largest prime number for the given input number
   * @param number the given input number
   * @return an option of a prime number
   */
  private def largestPrime(number: Long): Option[Long] = {
    var largestPrime: Option[Long] = None
    var m = 2L
    while (m <= number / m) {
      if (number % m == 0 && isPrime(m)) {
        largestPrime = Some(m)
      }
      m += 1
    }
    largestPrime
  }

  /**
   * Determines whether the given number is a prime number
   * @param number the given number
   * @return true, if the number is a prime number (e.g. 2, 3, 5, 7, ...)
   */
  private def isPrime(number: Long): Boolean = {
    var m = 2L
    while (m <= number / m) {
      if (number % m == 0) return false
      m += 1
    }
    true
  }

}