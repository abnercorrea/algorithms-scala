package leetcode.linkedin

import scala.collection.mutable

object LongestPalindromeSubstring extends App {
    val cache = mutable.Set[(Int, Int)]()

    def isPalindrome(s: String, start: Int, end: Int): Boolean = {
        if (start >= end) return true

        if (cache.contains((start, end))) return true

        val palindrome = s(start) == s(end) && isPalindrome(s, start + 1, end - 1)

        if (palindrome) cache += ((start, end))

        palindrome
    }

    def longestPalindrome(s: String): String = {
        cache.clear()
        var slice = (0, 0)
        var maxLen = 0
        for (len <- 1 to s.length) {
            for (start <- 0 to s.length - len) {
                if (isPalindrome(s, start, start + len - 1)) {
                    if (len > maxLen) {
                        maxLen = len
                        slice = (start, start + len)
                    }
                }
            }
        }
        s.slice(slice._1, slice._2)
    }

    def isPalindromeBruteForce(s: String, start: Int, end: Int): Boolean = {
        for (i <- 0 to (end - start) / 2) {
            if (s(start + i) != s(end - i)) return false
        }
        true
    }

    def longestPalindromeBruteForce(s: String): String = {
        for (len <- s.length to 1 by -1) {
            for (start <- 0 to s.length - len) {
                if (isPalindromeBruteForce(s, start, start + len - 1)) {
                    return s.slice(start, start + len)
                }
            }
        }
        ""
    }

    println(longestPalindrome("abbccd"))
    println(longestPalindrome("dsjklddirnviencjkkjdnjdndnjwnjsw"))
}