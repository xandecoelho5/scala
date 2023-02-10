@main def defaultParameters(): Unit =
  log("System starting") // prints INFO: System starting
  log("User not found", "WARNING") // prints WARNING: User not found

  printName("John", "Smith") // Prints "John Smith"
  printName(first = "John", last = "Smith") // Prints "John Smith"
  printName(last = "Smith", first = "John") // Prints "John Smith"
//  printName(last = "Smith", "john") // error: positional after named argument

def log(message: String, level: String = "INFO"): Unit = println(s"$level: $message")

object XD:
  def func(x: Int = 34): Unit = println("a")
//  def func(y: String = "abc"): Unit = println("a")

def printName(first: String, last: String): Unit =
  println(first + " " + last)
