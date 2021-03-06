package leet

object Leetspeak {
  val l33t = Map(
    "A" -> "4", "B" -> "8", "C" -> "(", "D" -> "|)", "E" -> "3", "F" -> "|=",
    "G" -> "6", "H" -> "#", "I" -> "!", "J" -> "_|", "K" -> "|<", "L" -> "1",
    "M" -> """/\/\""", "N" -> """|\|""", "O" -> "0", "P" -> "9", "Q" -> "0",
    "R" -> "2", "S" -> "5", "T" -> "7", "U" -> "|_|", "V" -> """\/""",
    "W" -> """\/\/""", "X" -> "><", "Y" -> "`/", "Z" -> "z", "Ä" -> "43",
    "Ö" -> "03", "Ü" -> "|_|"
  )
  def leet(s: String): String = {
    /*
    s.map(s => s.toUpper).map(c => {
      if (l33t(c.toString) != null) l33t(c.toString)
      else c.toString
    }).fold("")((acc, c) => acc + c)
     */
    s.toUpperCase().flatMap(c => l33t.getOrElse(c.toString, c.toString))
  }

  def main(args: Array[String]) = println(leet("Leetspeak"))
}
