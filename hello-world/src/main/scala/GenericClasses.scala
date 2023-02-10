@main def genericClasses(): Unit =
  val stack = Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop()) // prints 2
  println(stack.pop()) // prints 1

  val stack2 = Stack[Fruit]
  val apple = Apple()
  val banana = Banana()

  stack2.push(apple)
  stack2.push(banana)

class Stack[A]:
  private var elements: List[A] = Nil
  def push(x: A): Unit =
    elements = x :: elements
  def peek: A = elements.head
  def pop(): A =
    val currentTop = peek
    elements = elements.tail
    currentTop

class Fruit
class Apple extends Fruit
class Banana extends Fruit
