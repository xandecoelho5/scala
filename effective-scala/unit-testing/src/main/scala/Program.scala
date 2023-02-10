import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

@main def main(): Unit =
  println("Hello world!")

def add(a: Int, b: Int): Int = a + b

def fibonacci2(n: Int): Int =
  if n <= 1 then n
  else fibonacci2(n - 1) + fibonacci2(n - 2)
  
def fibonacci(n: Int): Int = 
  @tailrec
  def loop(n: Int, a: Int, b: Int): Int =
    if n <= 1 then a
    else loop(n - 1, b, a + b)
  loop(n, 0, 1)

def fibonacci3(n: Int): Int =
  val arr = ArrayBuffer(0, 1)
  for i <- 2 to n do
    arr += arr(i - 1) + arr(i - 2)
  arr(n)