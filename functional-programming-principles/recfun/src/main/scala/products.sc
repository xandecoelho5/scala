def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  def recur(a: Int): Int =
    if a > b then zero
    else combine(f(a), recur(a + 1))

  recur(a)

def sum(f: Int => Int) = mapReduce(f, (x, y) => x + y, 0)
def product(f: Int => Int) = mapReduce(f, (x, y) => x * y, 1)

product(x => x * x)(1, 5)

def fact(n: Int) = product(x => x)(1, n)
sum(fact)(1, 5)
fact(5)


def f(a: String)(b: Int)(c: Boolean): String =
  "(" + a + ", " + b + ", " + c + ")"

val partialApplication1 = f("Scala")

val partialApplication2 = partialApplication1(42)
