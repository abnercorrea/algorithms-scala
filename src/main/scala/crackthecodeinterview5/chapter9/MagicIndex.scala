package crackthecodeinterview5.chapter9

object MagicIndex extends App {

    // brute force O(n)
    def magicIndex(A: Array[Int]): Int = {
        for (i <- (0 to A.length - 1)) {
            if (A(i) == i) return i
            if (A(i) > i) return -1
        }

        -1
    }

    //  0,1,2,3,4,5,6
    // -1,0,1,6,7,8,9
    // -1,0,1,2,3,4,6

    // use binary search!!! O(log(n))
    def magicIndexBinSearch(A: Array[Int]): Int = {
        val end = A.length - 1

        def magicIndex(start: Int): Int = {
            if (start > end) return -1

            val mid = (start + end) / 2

            if (A(mid) == mid) return mid
            if (A(mid) > mid) return -1

            magicIndex(mid + 1)
        }

        magicIndex(0)
    }

    // Iterative version
    def magicIndexBinSearchIt(A: Array[Int]): Int = {
        var start = 0
        val end = A.length - 1

        while (start <= end) {
            val mid = (start + end) / 2

            if (A(mid) == mid) return mid
            if (A(mid) > mid) return -1

            start = mid + 1
        }

        -1
    }


}
