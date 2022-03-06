import scala.annotation.tailrec

@tailrec
final def factorial(i: BigInt, f: BigInt = 1): BigInt = if(i == 1) return f else factorial(i - 1, f * i)

<console>:48: error: could not optimize @tailrec annotated method factorial: it contains a recursive call not in tail position
       final def factorial(i: BigInt): BigInt = if(i == 1) i else i * factorial(i - 1)
                                                                    ^

