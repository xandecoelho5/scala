import scala.util.Random

@main def extractorObjects(): Unit =
  val customer1ID = CustomerID("Sukyoung") // Sukyoung--23098234908
  customer1ID match
    case CustomerID(name) => println(name) // prints Sukyoung
    case _ => println("Could not extract a CustomerID")

  val customer2ID = CustomerID("Nico")
  val CustomerID(name) = customer2ID
  println(name) // prints Nico

  val name2 = CustomerID.unapply(customer2ID).get

object CustomerID:
  def apply(name: String) = s"$name--${Random.nextLong()}"

  def unapply(customerID: String): Option[String] =
    val stringArray: Array[String] = customerID.split("--")
    if stringArray.tail.nonEmpty then Some(stringArray.head) else None
