@main def forComprehensions(): Unit =
  val userBase = List(
    User("Travis", 28),
    User("Kelly", 33),
    User("Jennifer", 44),
    User("Dennis", 23))

  val twentySomethings =
    for user <- userBase if user.age >= 20 && user.age < 30
      yield user.name // i.e. add this to a list

  twentySomethings.foreach(println) // prints Travis Dennis

  foo(10, 10).foreach {
    (i, j) => println(s"($i, $j) ") // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5) (6, 4) (7, 3) (8, 2) (9, 1)
  }

  foo1(10, 10)

case class User(name: String, age: Int)

def foo(n: Int, v: Int) =
  for i <- 0 until n
      j <- 0 until n if i + j == v
  yield (i, j)

def foo1(n: Int, v: Int) =
  for i <- 0 until n
      j <- 0 until n if i + j == v
  do println(s"($i, $j)")
