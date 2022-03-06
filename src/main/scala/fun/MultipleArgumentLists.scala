// Syntax Sugar
def fss[T](x: T)(f: T => String) = f(x)

// SWEET!!!
val f1 = fss(1){ 
	x => s"String $x" 
}

// Type inference
def m1[A](a: A, f: A => String) = f(a) 
m1: [A](a: A, f: A => String)String

def m2[A](a: A)(f: A => String) = f(a) 
m2: [A](a: A)(f: A => String)String

m1(100, i => s"$i + $i") 
<console>:55: error: missing parameter type
              m1(100, i => s"$i + $i") 
                      ^

m2(100)(i => s"$i + $i")
res71: String = 100 + 100


// V1 - BAD IDEA
// Implicit arguments
def calculate(x: Int)(implicit f: (Int) => Int): Int = f(x)

// Uses identity function f(x) = x
calculate(9)
res72: Int = 9

implicit def square = (a: Int) => a * a

calculate(9)
<console>:60: error: ambiguous implicit values:
 both method conforms in object Predef of type [A]=> <:<[A,A]
 and method square of type => Int => Int
 match expected type Int => Int
              calculate(9)
                       ^

// problem is that there is another implicit Int => Int already in scope that comes from Predef. 
// Namely =:=[Int, Int], which extends Int => Int. 
// Because this already exists in scope as a function, the compiler sees no need to look for anything else.
// Having an implicit Int => Int is probably not a good idea. Use a type class that wraps a function, instead.

// V2 - using wrapper class
case class WrapperF[A](f: A => A)

implicit val square = WrapperF[Int](i => i * i)

def calculate(x: Int)(implicit wf: WrapperF[Int]): Int = wf.f(x) 

calculate(9)
// SUCCESS!!!
res77: Int = 81