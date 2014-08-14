package study.euler

import org.junit.Test
import org.slf4j.LoggerFactory

/**
 * Problem #4: A palindromic number reads the same both ways. The largest
 * palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Answer: The largest palindrome is 906609 = 913 x 993.
 */
class Problem04() {
  val logger = LoggerFactory.getLogger(getClass)

  @Test
  def solve() {
    // the largest 3-digit number is 999 
    val number = largestPalindrome(999)
    number match {
      case Some((a, b, product)) =>
        logger.info(s"The largest palindrome is $product = $a x $b.")
      case None =>
        logger.info(s"No palindrome was found")
    }
  }

  private def largestPalindrome(maxValue: Int): Option[(Int, Int, Int)] = {
    var largest: Option[(Int, Int, Int)] = None
    var a = 100
    while (a < 999) {
      var b = 100
      while (b < 999) {
        val product = a * b
        if (isPalindrome(product)) {
          largest =
            if (largest.isEmpty) Some((a, b, product))
            else
              for { (i, j, current) <- largest } yield if (product > current) (a, b, product) else (i, j, current)
        }
        b += 1
      }
      a += 1
    }
    largest
  }

  private def isPalindrome(number: Int): Boolean = {
    var num = number
    var rev = 0
    while (num > 0) {
      val digit = num % 10
      rev = rev * 10 + digit
      num = num / 10
    }
    number == rev
  }

}