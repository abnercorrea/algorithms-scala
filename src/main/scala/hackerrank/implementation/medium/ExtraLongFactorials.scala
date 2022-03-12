package hackerrank.implementation.medium

object ExtraLongFactorials {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    def extraLongFactorials(n: Int): BigInt = {
        val factorial = (1 to n).foldLeft(BigInt(1)){(factorial, i) => factorial * i}
        //val factorial = (1 to n).map(BigInt(_)).reduce{(a, b) => a * b}
        
        println(factorial)
        
        factorial
    }

    def main(args: Array[String]) {
        val n = List(4, 20, 40, 100)
        
        n.foreach(extraLongFactorials)
    }
}
