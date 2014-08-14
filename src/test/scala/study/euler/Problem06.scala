package study.euler

import org.junit.Test
import org.slf4j.LoggerFactory

/**
 * The sum of the squares of the first ten natural numbers is,
 * 			1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * 			(1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 - 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */
class Problem06() {
  val logger = LoggerFactory.getLogger(getClass)

  @Test
  def solve() {
    val sumOfSquares = ((1 to 100) map (n => n * n)).sum
    val theSum =  (1 to 100).sum
    val squareOfSum = theSum * theSum
    val diff = squareOfSum - sumOfSquares
    
    logger.info(s"sumOfSquares = $sumOfSquares")
    logger.info(s"squareOfSum = $squareOfSum")
    logger.info(s"difference = $diff")
  }

}