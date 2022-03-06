// Me
val fi: PartialFunction[Any, Int] = { case i: Int => i * 2 }
val ff: PartialFunction[Any, Int] = { case i: Float => i.toInt * 2 }
fi.isDefinedAt(1)
true
fi.isDefinedAt(1F)
false
ff.isDefinedAt(1F)
true
ff.isDefinedAt(1)
false

val fx = fi orElse ff
// COMPOSE in case is not defined
val fx = fi.orElse(ff)

// Checks if is defined
fx.isDefinedAt(1F)
true
fx.isDefinedAt(1)
true

// LIFTS as a function that returns no MatchError... uses Option for that
fx.lift
Any => Option[Int] = <function1>
fx.lift(1)
Option[Int] = Some(2)
fx.lift(1F)
Option[Int] = Some(2)
fx.lift(1D)
Option[Int] = None

val square = (n: Int) => n * n 

// COMPOSE!!!!
val twoXsquare = square.compose(fx)
twoXsquare: Any => Int = <function1>

twoXsquare(1)
Int = 4

twoXsquare(2F)
Int = 16

twoXsquare(4D)
scala.MatchError: 4.0 (of class java.lang.Double)

// BOOK
val pf1: PartialFunction[Any,String] = { case s:String => "YES" } 
val pf2: PartialFunction[Any,String] = { case d:Double => "YES" } 

val pf = pf1 orElse pf2 

def tryPF(x: Any, f: PartialFunction[Any,String]): String = try { f(x).toString } catch { case _: MatchError => "ERROR!" }

def d(x: Any, f: PartialFunction[Any,String]) = f.isDefinedAt(x).toString

println(" | pf1 - String | pf2 - Double | pf - All") 
println("x | def? | pf1(x) | def? | pf2(x) | def? | pf(x)") 
println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++") 

List("str", 3.14, 10) foreach { x =>
  printf("%-5s | %-5s | %-6s  | %-5s | %-6s  | %-5s | %-6s\n", x.toString, d(x,pf1), tryPF(x,pf1), d(x,pf2), tryPF(x,pf2), d(x,pf), tryPF(x,pf))
}


