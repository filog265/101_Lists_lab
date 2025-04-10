object task2 extends App {
  val names = List("Pedro", "Filippo", "Esteban", "Santiago")

  println(names.mkString)

  def isPaulThere(l: List[String]): Unit ={
    if(l.contains("Paul")) println("Paul is on the list.")
    else println("Paul isn't on the list.")
  }

  isPaulThere(names)
}
