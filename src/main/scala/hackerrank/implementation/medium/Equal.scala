package hackerrank.implementation.medium

object Equal extends App {

    def equal(arr: Array[Int]): Int = {
        var numOps = 0
        val leftoverFreq = new Array[Int](5)

        arr.foreach { i =>
            val choc = i - arr.min
            numOps += choc / 5
            leftoverFreq(choc % 5) += 1
        }

        val extraOps = Array(
            (leftoverFreq(1) + leftoverFreq(2)) + 2 * (leftoverFreq(3) + leftoverFreq(4)), // min
            (leftoverFreq(0) + leftoverFreq(1) + leftoverFreq(4)) + 2 * (leftoverFreq(2) + leftoverFreq(3)), // min -1
            (leftoverFreq(0) + leftoverFreq(3)) + 2 * (leftoverFreq(1) + leftoverFreq(2) + leftoverFreq(4)), // min O
        )

        numOps + extraOps.min
    }

    println(equal(Array(2, 2, 3, 7)))
    println(equal(Array(10, 7, 12)))
    println(equal(Array(1, 1, 1)))
    println(equal(Array(761, 706, 697, 212, 97, 845, 151, 637, 102, 165, 200, 34, 912, 445, 435, 53, 12, 255, 111, 565, 816, 632, 534, 617, 18, 786, 790, 802, 253, 502, 602, 15, 208, 651, 227, 305, 848, 730, 294, 303, 895, 846, 337, 159, 291, 125, 565, 655, 380, 28, 221, 549, 13, 107, 166, 31, 245, 308, 185, 498, 810, 139, 865, 370, 790, 444, 27, 639, 174, 321, 294, 421, 168, 631, 933, 811, 756, 498, 467, 137, 878, 40, 686, 891, 499, 204, 274, 744, 512, 460, 242, 674, 599, 108, 396, 742, 552, 423, 733, 79, 96, 27, 852, 264, 658, 785, 76, 415, 635, 895, 904, 514, 935, 942, 757, 434, 498, 32, 178, 10, 844, 772, 36, 795, 880, 432, 537, 785, 855, 270, 864, 951, 649, 716, 568, 308, 854, 996, 75, 489, 891, 331, 355, 178, 273, 113, 612, 771, 497, 142, 133, 341, 914, 521, 488, 147, 953, 26, 284, 160, 648, 500, 463, 298, 568, 31, 958, 422, 379, 385, 264, 622, 716, 619, 800, 341, 732, 764, 464, 581, 258, 949, 922, 173, 470, 411, 672, 423, 789, 956, 583, 789, 808, 46, 439, 376, 430, 749, 151)))

    sys.exit(0)
}
