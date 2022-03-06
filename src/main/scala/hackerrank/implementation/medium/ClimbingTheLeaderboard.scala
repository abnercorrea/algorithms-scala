import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result {

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
        val n = ranked.size
         
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
        val ranks = new Array[Int](player.size)
        var j = 0
        var rank = 1
        val n = ranked.size
        
        for (i <- player.size - 1 to 0 by -1) {
            val score = player(i)
            
            while (j < n && score < ranked(j)) {
                j += 1
                if (j == n || ranked(j) != ranked(j - 1)) rank += 1
            }
            
            ranks(i) = rank
        }
        
        ranks
    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val rankedCount = StdIn.readLine.trim.toInt

        val ranked = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

        val playerCount = StdIn.readLine.trim.toInt

        val player = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

        val result = Result.climbingLeaderboard(ranked, player)

        printWriter.println(result.mkString("\n"))

        printWriter.close()
    }
}
fv r