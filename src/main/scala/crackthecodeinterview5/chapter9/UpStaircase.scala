package crackthecodeinterview5.chapter9

object UpStaircase extends App {

	// Recursive
	// Time: O(3^n), Stack Space: O(3^n)
	def upStaircaseR(n: Int): Long = {
		if (n == 0) return 0L
		if (n == 1) return 1L
		if (n == 2) return 2L
		if (n == 3) return 4L

		upStaircaseR(n - 1) + upStaircaseR(n - 2) + upStaircaseR(n - 3)
	}

	// Dynamic Progaming
	val upStaircaseCache = new Array[Long](10000)

	// Time: O(n), Stack Space: O(n), Heap Space O(n)
	def upStaircaseDP(n: Int): Long = {
		if (n == 0) return 0L
		if (n == 1) return 1L
		if (n == 2) return 2L
		if (n == 3) return 4L

		if (upStaircaseCache(n) != 0) return upStaircaseCache(n)

		upStaircaseCache(n) = upStaircaseDP(n - 1) + upStaircaseDP(n - 2) + upStaircaseDP(n - 3)

		upStaircaseCache(n)
	}

	// Iterative
	// Time: O(n), Stack and Heap O(1). NICE!!!
	def upStaircaseIt(n: Int): Long = {
		if (n == 0) return 0L
		if (n == 1) return 1L
		if (n == 2) return 2L
		if (n == 3) return 4L

		var N = 0L
		var nMinus1 = 4L
		var nMinus2 = 2L
		var nMinus3 = 1L

		for (_ <- 4 to n) {
			N = nMinus1 + nMinus2 + nMinus3
			nMinus3 = nMinus2
			nMinus2 = nMinus1
			nMinus1 = N
		}

		N
	}

	def benchmark(f: Int => Long, n: Int): Unit = {
		val start = System.nanoTime
		val a = f(n)
		val end = System.nanoTime

		println(s"$a - ${end - start}ns")
	}

	benchmark(upStaircaseR, 30)
	benchmark(upStaircaseDP, 30)
	benchmark(upStaircaseIt, 30)
}