// WWWWW
// LLBBO
// GBBBG
// WWWWW

// 1,2,P
// WWWWW
// LLPPO
// GPPPG
// WWWWW

// WATCH OUT!!! since x is horizontal and y is vertical, we need to invert the indexes when accessing the Array... image(y)(x)
def paintFill(image: Array[Array[Int]], px: Int, py: Int, newColor: Int) {
	val oldColor = image(py)(px)
	val maxX = image.size
	val maxY = image(0).size

	def paintFill(x: Int, y: Int) {
		if (x < 0 || x >= maxX || y < 0 || y >= maxY || image(y)(x) != oldColor) return

		image(y)(x) = newColor

		if (x <= px) paintFill(x - 1, y)
		if (x >= px) paintFill(x + 1, y)
		if (y <= py) paintFill(x, y - 1)
		if (y >= py) paintFill(x, y + 1)
	}

	paintFill(px, py)
}

val image = Array(
	Array(0,0,0,0,0), 
	Array(1,1,2,2,3), 
	Array(4,2,2,2,4), 
	Array(0,0,0,0,0) 
)

paintFill(image, 2, 1, 5)