def permutations(s: String): Array[String] = {
	val permutation = new Array[Char](s.length)
	val indexes = scala.collection.mutable.Set[Int]() ++ (0 until s.length)
	val results = scala.collection.mutable.ArrayBuffer[String]()

	def permutations(index: Int) {
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

permutations("ABCDE")
permutations("ABCDE").size

// Needs 4Gb of HEAP size to run... factorial :( 
permutations("ABCDEFGHIJK").size