package hackerrank.implementation.medium


object ClimbingTheLeaderboard {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    def climbingLeaderboard1st(ranked: Array[Int], player: Array[Int]): Array[Int] = {
        var j = 0
        var rank = 1
        val n = ranked.length
         
        val ranks = player.reverse.map{ score =>
            while (j < n && score < ranked(j)) {
                j += 1
                if (j == n || ranked(j) != ranked(j - 1)) rank += 1
            }
            
            rank
        }
        
        ranks.reverse
    }

    def climbingLeaderboard(ranked: Array[Int], player: Array[Int]): Array[Int] = {
        val ranks = new Array[Int](player.length)
        var j = 0
        var rank = 1
        val n = ranked.length
        
        for (i <- player.length - 1 to 0 by -1) {
            val score = player(i)
            
            while (j < n && score < ranked(j)) {
                j += 1
                if (j == n || ranked(j) != ranked(j - 1)) rank += 1
            }
            
            ranks(i) = rank
        }
        
        ranks
    }

    def main(args: Array[String]): Unit = {
        val ranked = Array(100, 90, 90, 80)
        val player = Array(5, 25, 75, 105)

        val result = climbingLeaderboard(ranked, player)

        println(result.mkString("\n"))
    }
}
