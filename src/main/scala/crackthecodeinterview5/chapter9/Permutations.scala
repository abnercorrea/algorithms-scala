package crackthecodeinterview5.chapter9

import scala.collection.mutable

object Permutations extends App {
    def permutations(s: String): Array[String] = {
        val permutation = new Array[Char](s.length)
        val indexes = mutable.Set[Int]() ++ (0 until s.length)
        val results = mutable.ArrayBuffer[String]()

        def permutations(index: Int): Unit = {
            if (index == s.length) {
                results += new String(permutation)

                return
            }

            for (i <- indexes) {
                permutation(index) = s.charAt(i)
                indexes -= i

                permutations(index + 1)

                indexes += i
            }
        }

        permutations(0)

        results.toArray
    }

    println(permutations("ABC").mkString(","))
    println(permutations("ABCDE").length)
}