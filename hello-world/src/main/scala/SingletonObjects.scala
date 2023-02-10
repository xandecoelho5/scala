import scala.math.{Pi, pow}

@main def singletonObjects(): Unit =
  val circle1 = Circle(5.0)
  circle1.area

  val scalaCenterEmail = Email1.fromString("scala.center@epfl.ch")
  scalaCenterEmail match
    case Some(email) => println(
      s"""Registered an email
         |Username: ${email.username}
         |Domain name: ${email.domainName}
       """.stripMargin)
    case None => println("Error: could not parse email")

object Logger:
  def info(message: String): Unit = println(s"INFO: $message")

class Project(name: String, daysToComplete: Int)

class Test:
  val project1 = Project("TPS Reports", 1)
  val project2 = Project("Website redesign", 5)
//  info("Created projects")  // Prints "INFO: Created projects"

case class Circle(radius: Double):
  import Circle.*
  def area: Double = calculateArea(radius)

object Circle:
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)

class Email1(val username: String, val domainName: String)

object Email1:
  def fromString(emailString: String): Option[Email1] =
    emailString.split('@') match
      case Array(a, b) => Some(Email1(a, b))
      case _ => None
