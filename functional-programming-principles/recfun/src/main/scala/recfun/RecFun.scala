package recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if c == 0 || c == r then 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */

  def balance(chs: List[Char]): Boolean =
    @tailrec
    def balancer(chars: List[Char], response: Array[Char]): Boolean =
      if chars.isEmpty then response.isEmpty

      val char = chars.head
      if char == '(' then
//        response = response :+ char
        balancer(chars.tail, response)
      else if char == ')' then
        if response.isEmpty || response.last != '(' then false
        else balancer(chars.tail, response.dropRight(1))
      else
        balancer(chars.tail, response)

    balancer(chs, Array())

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
