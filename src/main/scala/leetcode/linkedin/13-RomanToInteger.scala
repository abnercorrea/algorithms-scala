package leetcode.linkedin

object RomanToInt extends App {
    def romanToInt(s: String): Int = {
        var base10 = 0
        var i = 0
        val len = s.length

        while (i < len) {
            val c = s(i)

            if (c == 'M') {
                base10 += 1000
                if (i < len - 1 && s(i + 1) == 'M') {
                    if (i < len - 2 && s(i + 2) == 'M') {
                        base10 += 2000
                        i += 2
                    }
                    else {
                        base10 += 1000
                        i += 1
                    }
                }
            }
            else if (c == 'D') {
                base10 += 500
            }
            else if (c == 'C') {
                base10 += 100
                if (i < len - 1) {
                    if (s(i + 1) == 'M') {
                        base10 += 800
                        i += 1
                    }
                    else if (s(i + 1) == 'D') {
                        base10 += 300
                        i += 1
                    }
                    else if (s(i + 1) == 'C') {
                        if (i < len - 2 && s(i + 2) == 'C') {
                            base10 += 200
                            i += 2
                        }
                        else {
                            base10 += 100
                            i += 1
                        }
                    }
                }
            }
            else if (c == 'L') {
                base10 += 50
            }
            else if (c == 'X') {
                base10 += 10
                if (i < len - 1) {
                    if (s(i + 1) == 'C') {
                        base10 += 80
                        i += 1
                    }
                    else if (s(i + 1) == 'L') {
                        base10 += 30
                        i += 1
                    }
                    else if (s(i + 1) == 'X') {
                        if (i < len - 2 && s(i + 2) == 'X') {
                            base10 += 20
                            i += 2
                        }
                        else {
                            base10 += 10
                            i += 1
                        }
                    }
                }
            }
            else if (c == 'V') {
                base10 += 5
            }
            else if (c == 'I') {
                base10 += 1
                if (i < len - 1) {
                    if (s(i + 1) == 'X') {
                        base10 += 8
                        i += 1
                    }
                    else if (s(i + 1) == 'V') {
                        base10 += 3
                        i += 1
                    }
                    else if (s(i + 1) == 'I') {
                        if (i < len - 2 && s(i + 2) == 'I') {
                            base10 += 2
                            i += 2
                        }
                        else {
                            base10 += 1
                            i += 1
                        }
                    }
                }
            }
            i += 1
        }

        base10
    }

    println(romanToInt("MMMCCCXXXIII"))
    println(romanToInt("CMXCIX"))
    println(romanToInt("CDXLIV"))
    println(romanToInt("MMMDCCXXXIV"))
}