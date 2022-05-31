package leetcode.linkedin

import scala.collection.mutable

object ValidParentheses extends App {
    def isValid(s: String): Boolean = {
        val openStack = mutable.Stack[Char]()

        for (c <- s) {
            if (c == ')' || c == ']' || c == '}') {
                if (openStack.isEmpty) return false
                val o = openStack.pop()
                if ((c == ')' && o != '(') || (c == ']' && o != '[') || (c == '}' && o != '{')) {
                    return false
                }
            }
            else {
                openStack.push(c)
            }
        }

        openStack.isEmpty
    }

    println(isValid("()"))
    println(isValid("{"))
    println(isValid("{)"))
    println(isValid("{})"))
    println(isValid("{[(()[]{})]}"))
}