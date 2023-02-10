@main def variances(): Unit =
  val myAnimal: Animal = Cat1("Felix")

  val myCatBox: Box[Cat1] = Box[Cat1](Cat1("Felix"))
//  val myAnimalBox: Box[Animal] = myCatBox // this doesn't compile
//  val myAnimal2: Animal = myAnimalBox.content

  val catbox: ImmutableBox[Cat1] = ImmutableBox[Cat1](Cat1("Felix"))
  val animalBox: ImmutableBox[Animal] = catbox // now this compiles

  val cats: List[Cat1] = List(Cat1("Whiskers"), Cat1("Tom"))
  val dogs: List[Dog1] = List(Dog1("Fido"), Dog1("Rex"))

  // prints: Whiskers, Tom
  printAnimalNames(cats)

  // prints: Fido, Rex
  printAnimalNames(dogs)

//  val animalSerializer: Serializer[Animal] = Serializer[Animal]():
//    def serialize(animal: Animal): String = s"""{ "name": "${animal.name}" }"""
//
//  val catSerializer: Serializer[Cat] = animalSerializer
//  catSerializer.serialize(Cat("Felix"))

class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class

// Invariance
class Box[A](var content: A)
// Covariance
class ImmutableBox[+A](val content: A)
// Contravariance
abstract class Serializer[-A]:
  def serialize(a: A): String

abstract class Animal:
  def name: String

case class Cat1(name: String) extends Animal
case class Dog1(name: String) extends Animal

def printAnimalNames(animals: List[Animal]): Unit =
  animals.foreach {
    animal => println(animal.name)
  }
