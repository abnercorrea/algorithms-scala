rdef robotPaths(X: Int, Y: Int, offLimits: Set[(Int, Int)] = Set()): Long = {
	val robotPathCache = Array.ofDim[Long](100, 100)

	def robotPathsR(x: Int, y: Int): Long = {
		if (x > X) return 0
		if (y > Y) return 0
		if ((x, y) == (X, Y)) return 1
		if (offLimits.contains((x, y))) return 0

		if (robotPathCache(x)(y) != 0) return robotPathCache(x)(y)

		robotPathCache(x)(y) = robotPathsR(x + 1, y) + robotPathsR(x, y + 1)

		robotPathCache(x)(y)
	}
	
	robotPathsR(0, 0)
}