val a = Array(1,2,3,4,5)
val l = List(9,8,7,6,5)

def sum(x: Int*) = x.sum
def max(x: Int*) = x.max

sum(a : _*)
max(l : _*)
