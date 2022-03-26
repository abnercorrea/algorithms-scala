package hackerrank.recursion.medium


object PowerSum extends App {

    def powerSumRec(x: Int, powers: Array[Int], sum: Int, i: Int): Int = {
        if (i == powers.length) return 0

        var combinations = 0

        for (j <- i until powers.length) {
            val newSum = sum + powers(j)

            if (newSum == x)
                combinations += 1
            else if (newSum < x)
                combinations += powerSumRec(x, powers, newSum, j + 1)
        }

        combinations
    }

    def powerSum(x: Int, n: Int): Int = {
        val max = math.pow(x, 1F / n).toInt
        val powers = (1 to max).map(i => math.pow(i, n).toInt).toArray

        powerSumRec(x, powers, sum=0, i=0)
    }

    println(powerSum(10, 2))
    println(powerSum(100, 2))
    println(powerSum(100, 3))
    println(powerSum(500, 2))
}
