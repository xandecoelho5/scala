@main def higherOrderFunctions(): Unit =
  val salaries = Seq(20_000, 70_000, 40_000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
  println(newSalaries)

  val newSalariess = salaries.map(_ * 2)

  val domainName = "www.example.com"

  def getURL = urlBuilder(ssl = true, domainName)

  val endpoint = "users"
  val query = "id=1"
  val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String

  println("Factorial of 2: " + factorial(2))
  println("Factorial of 3: " + factorial(3))


case class WeeklyWeatherForecast(temperatures: Seq[Double]):
  private def convertCtoF(temp: Double) = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF

object SalaryRaiser:
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * salary)

def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String =
  val schema = if ssl then "https://" else "http://"
  (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"

def factorial(x: Int): Int =
  def fact(x: Int, accumulator: Int): Int =
    if x <= 1 then accumulator
    else fact(x - 1, x * accumulator)
  fact(x, 1)
