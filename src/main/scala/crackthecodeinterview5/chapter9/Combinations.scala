package crackthecodeinterview5.chapter9

import scala.collection.mutable.ArrayBuffer

object Combinations extends App {

    def combinations[T: Manifest](a: Array[T], n: Int): Array[Set[T]] = {
        val size = a.length
        val combination = new Array[T](n)
        val result = ArrayBuffer[Set[T]]()

        def combinations(combIndex: Int, aIndex: Int): Unit = {
            if (combIndex == n) {
                result += combination.toSet

                return
            }

            for (i <- aIndex to size - n - combIndex) {
                combination(combIndex) = a(i)

                combinations(combIndex + 1, i + 1)
            }
        }

        combinations(0, 0)

        result.toArray
    }

    def allSubsets[T: Manifest](arr: Array[T]): Array[Set[T]] = {
        val a = arr.toSet.toArray
        val result = ArrayBuffer[Set[T]]()

        for (n <- 1 to a.length) result ++= combinations(a, n)

        result.toArray
    }

    // 2^n times... O(2^n) not much can be done.
    def allSubsetsOneLiner[T: Manifest](a: Seq[T]): Seq[Seq[T]] = {
        for (i <- 0 until 1 << a.length) yield for (j <- a.indices if (i >> j & 1) == 1) yield a(j)
    }

    // main code
    println(combinations((1 to 3).toArray, 2).mkString(", "))
    println(allSubsets((1 to 3).toArray).mkString(", "))
}
