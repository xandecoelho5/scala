@main def classes(): Unit =
  val point1 = Point(2, 3)
  println(point1.x) // prints 2
  println(point1) // prints (2, 3)

  val origin = Point() // x and y are both set to 0
  val point2 = Point(1) // x is set to 1 and y is set to 0
  val point3 = Point(y = 2)
  println(point2) // prints (1, 0)
  println(point3) // prints (0, 2)

  val point4 = Point2()
  point4.x = 99
  point4.y = 101 // prints the warning

class Point(var x: Int = 0, var y: Int = 0):

  def move(dx: Int, dy: Int): Unit =
    x = x + dx
    y = y + dy

  override def toString: String =
    s"($x, $y)"
end Point


class Point2:
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x: Int = _x
  def x_=(newValue: Int): Unit =
    if newValue < bound then
      _x = newValue
    else
      printWarning()

  def y: Int = _y
  def y_=(newValue: Int): Unit =
    if newValue < bound then
      _y = newValue
    else
      printWarning()

  private def printWarning(): Unit =
    println("WARNING: Out of bounds")
end Point2

