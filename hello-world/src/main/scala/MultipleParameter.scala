@main def multipleParameter(): Unit =
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(0)((m, n) => m + n)
  println(res) // 55

  def foldLeft1[A, B](as: List[A], b0: B, op: (B, A) => B) = ???

  def firstWay = foldLeft1(numbers, 0, _ + _)
  def secondWay = foldLeft1(numbers, 0, (a: Int, b: Int) => a + b)

  def foldLeft2[A, B](as: List[A], b0: B)(op: (B, A) => B) = ???
  def possible = foldLeft2(numbers, 0)(_ + _)

  def execute(arg: Int)(using ec: scala.concurrent.ExecutionContext) = ???

  val numberFunc = numbers.foldLeft(List[Int]()) _

  val squares = numberFunc((xs, x) => xs :+ x * x)
  println(squares) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

  val cubes = numberFunc((xs, x) => xs :+ x * x * x)
  println(cubes) // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)

  def addMultiple(n1: Int)(n2: Int) = n1 + n2
  // two different ways of arriving at a curried version instead
  def add(n1: Int, n2: Int) = n1 + n2

  val addCurried1 = (add _).curried
  val addCurried2 = (n1: Int) => (n2: Int) => n1 + n2
  // regardless, all three call sites are identical
  addMultiple(3)(4) // 7
  addCurried1(3)(4) // 7
  addCurried2(3)(4) // 7

trait Iterable[A]:
  def foldLeft[B](z: B)(op: (B, A) => B): B
