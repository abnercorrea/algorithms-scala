package leetcode.linkedin

import scala.collection.mutable

object TwoSum extends App {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val numMap = mutable.Map[Int, Int]()

        for (i <- nums.indices) {
            if (numMap.contains(target - nums(i))) {
                return Array(i, numMap(target - nums(i)))
            }

            numMap(nums(i)) = i
        }

        Array()
    }

    println(twoSum(Array(1,2,3,4,5,6,7), 13).mkString(","))
}