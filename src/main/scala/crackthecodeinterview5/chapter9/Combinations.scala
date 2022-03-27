package crackthecodeinterview5.chapter9

import scala.collection.mutable.ArrayBuffer
import scala.language.implicitConversions


object Combinations extends App {

    class SeqWithPrettyPrint[+A](val seq: Seq[A]) {
        def prettyPrint: String = seq.mkString("[", ",", "]")
    }

    implicit def seqToSeqWithToString[A](seq: Seq[A]): SeqWithPrettyPrint[A] = new SeqWithPrettyPrint(seq)

    def combinations[T: Manifest](a: Array[T], n: Int): Array[Array[T]] = {
        val size = a.length
        val combination = a.slice(0, n)
        val result = ArrayBuffer[Array[T]]()

        def combinations(combIndex: Int, aIndex: Int): Unit = {
            if (combIndex == n) {
                result += combination.clone()

                return
            }

            for (i <- aIndex until size) {
                combination(combIndex) = a(i)

                combinations(combIndex + 1, i + 1)
            }
        }

        combinations(0, 0)

        result.toArray
    }

    def allSubsets[T: Manifest](arr: Array[T]): Array[Array[T]] = {
        val a = arr.toSet.toArray
        val result = ArrayBuffer[Array[T]]()

        for (n <- 1 to a.length) result ++= combinations(a, n)

        result.toArray
    }

    // 2^n times... O(2^n) not much can be done.
    def allSubsetsOneLiner[T: Manifest](a: Seq[T]): Seq[Seq[T]] = {
        for (i <- 0 until 1 << a.length) yield for (j <- a.indices if (i >> j & 1) == 1) yield a(j)
    }

    println("Pascal triangle:")
    for (n <- 0 to 10) {
        println((0 to n).map(combinations((1 to n).toArray, _).length).toSeq.prettyPrint)
    }
}
