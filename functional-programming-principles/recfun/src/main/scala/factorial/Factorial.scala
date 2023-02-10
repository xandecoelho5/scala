package factorial

import scala.annotation.tailrec

@main def factorialCalculation(): Unit =
  println(factorial(5, 1))

@tailrec
def factorial(n: Int, acc: Int): Int =
  if n == 1 then acc else factorial(n - 1, acc * n)
