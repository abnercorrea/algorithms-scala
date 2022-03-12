val f1: (Int, Int) => Int = _+_
f1: (Int, Int) => Int = <function2>

f1(1,2)
res0: Int = 3

// Trying to invoke f1 passing a tuple
f1((1,2))
<console>:9: error: not enough arguments for method apply: (v1: Int, v2: Int)Int in trait Function2.
Unspecified value parameter v2.
              f1((1,2))
                ^

// Using the "tupled" method                
f1.tupled
res5: ((Int, Int)) => Int = <function1>

// Yes!!! it works.
f1.tupled((1,2))
res7: Int = 3

// For a method (not an "actual" function defined with val f: (<type>, ...) => <type> = ...)
def f2(a: Int, b: Int): Int = a + b

// .tupled won't work...
f2.tupled
<console>:9: error: missing arguments for method f2;
follow this method with `_' if you want to treat it as a partially applied function
              f2.tupled
              ^

// But there is hope, partially applied functions can be used
(f2 _).tupled
res18: ((Int, Int)) => Int = <function1>

// There's always a way...
(f2 _).tupled((1,2))
res19: Int = 3

// you can also use currying if necessary (out of this context, but still awesome :)
f1.curried(1)(2)
res20: Int = 3

// YEAH, SCALA RULES.
