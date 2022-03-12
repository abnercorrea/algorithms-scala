scala -feature

import scala.language.postfixOps
/*
<console>:9: warning: postfix operator > should be enabled by making the implicit value scala.language.postfixOps visible.
This can be achieved by adding the import clause 'import scala.language.postfixOps' or by setting the compiler option -language:postfixOps.
See the Scala docs for value scala.language.postfixOps for a discussion why the feature should be explicitly enabled.
*/

def quicksort(xs: Array[Int]): Array[Int] = { 
  if (xs.length <= 1) xs
  else {
    val pivot = xs(xs.length / 2) 
    Array.concat(quicksort(xs filter (pivot >)), xs filter (pivot ==), quicksort(xs filter (pivot <)))
  } 
}

val a = Array(100, 23, 9, 1, 87, 45, 34, 23, 98, 22, 11)

quicksort(a)
  
