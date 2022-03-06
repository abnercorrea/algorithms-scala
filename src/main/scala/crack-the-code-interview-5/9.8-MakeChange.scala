// Input value in dollars (if not, make it * 100)
// Careful with repeated combinations conted twice !!!!
// (5,1,1), (1,5,1), (1,1,5) - Have to be counted only once!
// To solve this, it's passed the previous coin used to the recursion and the recursion is only called for for with a lower or equal value to the previous coin.

// 10: 10x1, 5x2, 5x1-1x5, 1x10
// 15: 10x1-5x1, 10x1-1x5, 5x3, 5x2-1x5, 5x1-1x10, 1x15
// 20: 10x2, 10x1-5x2, 10x1-5x1-1x5, 10x1-1x10, 5x4, 5x3-1x5, 5x2-1x10, 5x1-1x15, 1x20
// 30: 25x1-5x1, 25x1-1x5, 10x3, 10x2-5x2, 10x2-5x1-1x5, 10x2-1x10, 10x1-5x4, 10x1-5x3-1x5, 10x1-5x2-1x10, 10x1-5x1-1x15, 10x1-1x20, 5x6, 5x5-1x5, 5x4-1x10, 5x3-1x15, 5x2-1x20, 5x1-1x25, 1x30

def coinCombCount(v: Int): Int = {
	val coins = Array(25, 10, 5, 1)

	def coinCombCount(n: Int, previousCoin: Int): Int = {
		if (n < 0) return 0
		if (n == 0) return 1

		var count = 0

		for (coin <- coins)	
			if (coin <= previousCoin) {
				count += coinCombCount(n - coin, coin)
			}

		count
	}

	coinCombCount(v, 25)
}

// Dynamic programing version...
// Have to be very careful with this DP to prevent overlap.
// The solution was to use a Map with a composite key
def coinCombCountDP(v: Int): Int = {
	val coins = Array(25, 10, 5, 1)
	val cache = scala.collection.mutable.Map[String, Int]()

	def coinCombCountDP(n: Int, previousCoin: Int): Int = {
		if (n < 0) return 0
		if (n == 0) return 1

		var count = 0

		for (coin <- coins if coin <= previousCoin)	{
			val key = n.toString + "|" + coin.toString

			if (!cache.contains(key)) cache(key) = coinCombCountDP(n - coin, coin)
			
			count += cache(key)
		}

		count
	}

	coinCombCountDP(v, 25)
}

// From CCI
// Works, but has no DP optimization 
def makeChange(n: Int, denom: Int): Int = {
	if (denom == 1) return 1

	val nextDenom = denom match {
		case 25 => 10
		case 10 => 5
		case 5 => 1
	}

	var ways = 0

	for (i <- (0 to n / denom)) {
		ways += makeChange(n - i * denom, nextDenom)
	}

	ways
}

// Returns the actual coin combinations
def coinComb(v: Int): Array[Array[Int]] = {
	val coins = Array(25, 10, 5, 1)
	val result = scala.collection.mutable.ArrayBuffer[Array[Int]]()

	def coinComb(n: Int, previousCoin: Int, combination: Array[Int]) {
		if (n < 0) return
		
		if (n == 0) { 
			result += combination

			return
		}

		for (coin <- coins)	
			if (coin <= previousCoin) coinComb(n - coin, coin, combination ++ Array(coin))
	}

	coinComb(v, 25, Array[Int]())

	result.toArray
}


