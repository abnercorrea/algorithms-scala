// EXAMPLE 1

case class Employee(id: Int, firstName: String, lastName: String)

object Employee {
  // Note that because `Ordering[A]` is not contravariant, the declaration
  // must be type-parametrized in the event that you want the implicit
  // ordering to apply to subclasses of `Employee`.
  implicit def orderingByName[A <: Employee]: Ordering[A] =
    Ordering.by(e => (e.lastName, e.firstName))

  val orderingById: Ordering[Employee] = Ordering.by(e => e.id)
}

es.sorted() // will sort by name 

es.sorted(Employee.orderingById) // will sort by id


// EXAMPLE 2

import scala.util.Sorting

val pairs = Array(("a", 5, 2F), ("c", 3, 1F), ("b", 1, 3F))

// sort by first element
Sorting.quickSort(pairs)(Ordering.by[(String, Int, Float), String](_._1))

// sort by 2nd element
Sorting.quickSort(pairs)(Ordering.by[(String, Int, Float), Int](_._2))

// sort by third element
Sorting.quickSort(pairs)(Ordering.by[(String, Int, Float), Float](_._3))

// sort by the 3rd element, then 1st
Sorting.quickSort(pairs)(Ordering[(Float, String)].on(x => (x._3, x._1)))  
