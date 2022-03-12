/* ********************************************************************************************
Currying transforms a function that takes multiple arguments into a chain of functions, each taking a single argument.
named after the mathematician Haskell Curry

Note that currying, while similar, is not the same operation as partial function application
One of the significant differences between the two is that a call to a partially applied function returns the result right away, 
not another function down the currying chain.
this distinction can be illustrated clearly for functions whose arity is greater than two.

********************************
# Currying:
********************************
f(a,b,c) = f(a)(b)(c)
f(a) = g(b)(c)

Note that after calling f(a), we are left with a function that takes a single argument and returns another function, 
not a function that takes two arguments.

********************************
# Partial function application:
********************************
f(a,b,c)
f(a) = g(b, c)

Note that the result of partial function application in this case is a function that takes two arguments.
"if you fix the first arguments of the function, you get a function of the remaining arguments"

******************************************************************************************** */

val sum = (a: Int, b: Int) =>  a + b
(Int, Int) => Int = <function2>

// f(a, b) = f(a)(b) = a => (b => result)
sum.curried
Int => (Int => Int) = <function1>

// returns fs(b) = 1 + b
val fs = sum.curried(1)
fs: Int => Int = <function1>

// fs(2) = 1 + 2 = 3
fs(2)
3

// 1 + 2
sum.curried(1)(2)
3

// Curried funcions sintax
def cat1(s1: String)(s2: String) = s1 + s2

def cat2(s1: String) = (s2: String) => s1 + s2

// Calling both functions looks the same and returns the same result:
cat1("foo")("bar") 
res0: String = foobar

cat2("foo")("bar") 
res1: String = foobar


// treating the curried function as a partially applied function:
val cat1Hi = cat1("Hi")
<console>:61: error: missing arguments for method cat1;
follow this method with `_' if you want to treat it as a partially applied function
              cat1("Hi")
                  ^

// needs trailing underscore _
val cat1Hi = cat1("Hi")_ 
res79: String => String = <function1>


// the second syntax eliminates the requirement to add a trailing underscore when treating the curried function as a partially applied function
val cat2hello = cat2("Hello ") // No _ 
cat2hello: String => String = <function1>

cat2hello("World!")
res0: String = Hello World!

