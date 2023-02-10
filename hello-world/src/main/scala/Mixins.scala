@main def mixins(): Unit =
  val d = D()
  println(d.message) // I'm an instance of class B
  println(d.loudMessage) // I'M AN INSTANCE OF CLASS B

  val richStringIter = RichStringIter()
  richStringIter.foreach(println)

abstract class A:
  val message: String
class B extends A:
  val message = "I'm an instance of class B"
trait C extends A:
  def loudMessage: String = message.toUpperCase()
class D extends B, C

abstract class AbsIterator:
  type T
  def hasNext: Boolean
  def next(): T

class StringIterator(s: String) extends AbsIterator:
  type T = Char
  private var i = 0
  def hasNext: Boolean = i < s.length
  def next(): Char =
    val ch = s charAt i
    i += 1
    ch

trait RichIterator extends AbsIterator:
  def foreach(f: T => Unit): Unit = while hasNext do f(next())

class RichStringIter extends StringIterator("Scala"), RichIterator
