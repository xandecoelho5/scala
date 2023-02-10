@main def caseClasses(): Unit =
  val frankenstein = Book("978-0486282114")

  val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

  println(message1.sender) // prints guillaume@quebec.ca
//  message1.sender = "travis@washington.us" // this line does not compile

  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val messagesAreTheSame = message2 == message3  // true

  val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
  val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
  println(message5.sender) // travis@washington.us
  println(message5.recipient) // claire@bourgogne.fr
  println(message5.body) // "Me zo o komz gant ma amezeg"

case class Book(isbn: String)

case class Message(sender: String, recipient: String, body: String)
