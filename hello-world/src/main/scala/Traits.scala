import scala.collection.mutable.ArrayBuffer

@main def traits(): Unit =
  val iterator = new IntIterator(10)
  iterator.next() // returns 0
  iterator.next() // returns 1

  val dog = Dog("Harry")
  val cat = Cat("Sally")

  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name)) // Prints Harry Sally

trait Iterator[A]:
  def hasNext: Boolean
  def next(): A

class IntIterator(to: Int) extends Iterator[Int]:
  private var current = 0
  override def hasNext: Boolean = current < to
  override def next(): Int =
    if hasNext then
      val t = current
      current += 1
      t
    else
      0
end IntIterator

trait Pet:
  val name: String

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet
