package study.euler

import org.junit.{Assert, Test}
import org.slf4j.LoggerFactory

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 * 
 * Answer: The 1001st prime is 7927
 */
class Problem07() {
  val logger = LoggerFactory.getLogger(getClass)

  @Test
  def solve() {
    val nth = 1001
    val nthPrime = getNthPrime(nth)
    logger.info(s"The ${nth}${suffix(nth)} prime is $nthPrime")

    Assert.assertTrue(nthPrime == 7927)
  }

  private def getNthPrime(limit: Int): Int = {
    var primes = 2
    var number = 4
    var lastPrime = 2
    while (primes < limit) {
      if (isPrime(number)) {
        lastPrime = number
        primes += 1
      }
      number += 1
    }
    lastPrime
  }
  
  private def suffix(number:Int): String = {
    number % 10 match {
      case 1 => "st"
      case 2 => "nd"
      case 3 => "rd"
      case _ => "th"
    }
  }
 
  private def isPrime(number: Int): Boolean = {
    number match {
      case n if n < 2 => false
      case n if n == 2 => true
      case n =>
        var m = 2
        while (m < n && n / m >= 0) {
          if (n % m == 0) return false
          m += 1
        }
        true
    }
  }

}