import scala.collection.mutable.ArrayBuffer

def allSubsets[T](s: Set[T]): Array[Set[T]] = {
	val a = s.toArray
	val result = ArrayBuffer[Set[Int]]()

	for (n <- (1 to a.length)) result ++= combinations(a, n)	

	result.toArray	
}

def combinations(a: Array[Int], n: Int): Array[Set[Int]] = {
	val size = a.length
	val combination = new Array[Int](n)
	val result = ArrayBuffer[Set[Int]]()

	def combinations(combIndex: Int, aIndex: Int) {
		if (combIndex == n)  {
			result += combination.toSet

			return
		}

		for (i <- (aIndex to size - (n - combIndex))) {
			combination(combIndex) = a(i)	

			combinations(combIndex + 1, i + 1)
		}
	}

	combinations(0, 0)

	result.toArray
}


// Believe it or not, I've created a one-liner answer in scala. B-A-D-A-S-S-!-!-!
// 2^n times... O(2^n) not much can be done.
def allSubsets[T](a: Seq[T]): Seq[Seq[T]] = {
	for (i <- (0 until 1 << a.length)) yield for (j <- (0 until a.length) if (i >> j & 1) == 1) yield a(j)
}