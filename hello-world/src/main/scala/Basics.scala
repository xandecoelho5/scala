@main def basics(): Unit =
  val x: Int = 1 + 1
  println(1) // 1
  println(x) // 2
  println("Hello!") // Hello!
  println("Hello," + " world!") // Hello, world!

  println({
    val y = 1 + 1
    y + 1
  })

  var s = if (x == 0) 1 else 4;

  val addOne = (a: Int) => a + 1
  println(addOne(1))

  val add = (a: Int, b: Int) => a + b
  println(add(1, 2))

  val getTheAnswer = () => 42
  println(getTheAnswer()) // 42

  def add2(x: Int, y: Int): Int = x + y

  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(1, 2)(3)) // 9

  def name: String = System.getProperty("user.name")
  println("Hello, " + name + "!")

  def getSquareString(input: Double): String =
    val square = input * input
    square.toString
  println(getSquareString(2.5)) // 6.25

  val greeter = Greeter("Hello, ", "!")
  greeter.greet("Scala developer") // Hello, Scala developer!

  val newId: Int = IdFactory.create()
  println(newId) // 1
  val newerId: Int = IdFactory.create()
  println(newerId) // 2

  val greeters = DefaultGreeter()
  greeters.greet("Scala developer") // Hello, Scala developer!

  val customGreeter = CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer") // How are you, Scala developer?

class Greeter(prefix: String, suffix: String):
  def greet(name: String): Unit =
    println(prefix + name + suffix)

object IdFactory:
  private var counter = 0
  def create(): Int =
    counter += 1
    counter

trait Greeters:
  def greet(name: String): Unit =
    println("Hello, " + name + "!")

class DefaultGreeter extends Greeters

class CustomizableGreeter(prefix: String, postfix: String) extends Greeters:
  override def greet(name: String): Unit =
    println(prefix + name + postfix)
