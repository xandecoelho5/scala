@main def tuples(): Unit =
  val ingredient = ("Sugar", 25)
  println(ingredient(0)) // Sugar
  println(ingredient(1)) // 25

  val (name, quantity) = ingredient
  println(name) // Sugar
  println(quantity) // 25

  val planets = List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
    ("Mars", 227.9), ("Jupiter", 778.3))

  planets.foreach {
    case ("Earth", distance) =>
      println(s"Our planet is $distance million kilometers from the sun")
    case _ =>
  }

  val numPairs = List((2, 5), (3, -7), (20, 56))
  for (a, b) <- numPairs do
    println(a * b)


