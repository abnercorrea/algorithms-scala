//(())
//()()

// this is O(n!). Actual number of combinations is n! / 2
def generateParenthesis(n: Int): Array[String] = {
	val parenthesis = new Array[Char](2*n)
	val result = scala.collection.mutable.ArrayBuffer[String]()

	def generateParenthesis(open: Int, close: Int) {
		if (open == n && close == n) {
			result += new String(parenthesis) 
			return	
		}

		if (open < n) {
			parenthesis(open + close) = '('

			generateParenthesis(open + 1, close)	
		}

		if (close < open) {
			parenthesis(open + close) = ')'

			generateParenthesis(open, close + 1)	
		}	
	}

	generateParenthesis(0, 0)

	result.toArray
}

generateParenthesis(4).foreach(println)
// 17 takes more than 8Gb of RAM... factorial again.
generateParenthesis(10).size

