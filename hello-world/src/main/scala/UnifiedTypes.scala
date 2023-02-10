@main def unifiedTypes(): Unit =
  val list: List[Any] = List(
    "a string",
    732, // an integer
    'c', // a character
    true, // a boolean value
    () => "an anonymous function returning a string"
  )
  list.foreach(element => println(element))

  // Type Casting
  val x: Long = 987654321
  val y: Float = x.toFloat // 9.8765434E8 (note that some precision is lost in this case)

  val face: Char = '☺'
  val number: Int = face // 9786

  val a: Long = 987654321
  val b: Float = a.toFloat // 9.8765434E8
  //  val c: Long = b // Does not conform
